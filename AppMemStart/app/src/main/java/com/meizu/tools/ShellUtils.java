package com.meizu.tools;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ShellUtils {

	public static final String COMMAND_SU = "su";
	public static final String COMMAND_SH = "sh";
	public static final String COMMAND_EXIT = "exit\n";
	public static final String COMMAND_LINE_END = "\n";

	public static List<String> execCommand(String command, boolean isRoot) {
		return execCommand(new String[] { command }, isRoot, true);
	}

	public static List<String> execCommand(List<String> commands, boolean isRoot) {
		return execCommand(commands == null ? null : commands.toArray(new String[] {}), isRoot, true);
	}

	public static List<String> execCommand(String[] commands, boolean isRoot) {
		return execCommand(commands, isRoot, true);
	}

	public static List<String> execCommand(String command, boolean isRoot, boolean isNeedResultMsg) {
		return execCommand(new String[] { command }, isRoot, isNeedResultMsg);
	}

	public static List<String> execCommand(List<String> commands, boolean isRoot, boolean isNeedResultMsg) {
		return execCommand(commands == null ? null : commands.toArray(new String[] {}), isRoot, isNeedResultMsg);
	}

	public static List<String> execCommand(String[] commands, boolean isRoot, boolean isNeedResultMsg) {
		if (commands == null || commands.length == 0) {
			return null;
		}

		Process process = null;
		BufferedReader successResult = null;
		BufferedReader errorResult = null;
		StringBuilder successMsg = null;
		List<String> listSuccess = new ArrayList<>();
		List<String> listError = new ArrayList<>();
		StringBuilder errorMsg = null;

		DataOutputStream os = null;
		try {
			process = Runtime.getRuntime().exec(isRoot ? COMMAND_SU : COMMAND_SH);
			os = new DataOutputStream(process.getOutputStream());
			for (String command : commands) {
				if (command == null) {
					continue;
				}
				os.write(command.getBytes());
				os.writeBytes(COMMAND_LINE_END);
				os.flush();
			}
			os.writeBytes(COMMAND_EXIT);
			os.flush();
			if (isNeedResultMsg) {
				successMsg = new StringBuilder();
				errorMsg = new StringBuilder();
				successResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
				errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String s;
				while ((s = successResult.readLine()) != null) {
					successMsg.append(s + "\n");
					listSuccess.add(s);
				}
				while ((s = errorResult.readLine()) != null) {
					errorMsg.append(s + "\n");
					listError.add(s);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (successResult != null) {
					successResult.close();
				}
				if (errorResult != null) {
					errorResult.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (process != null) {
				process.destroy();
			}
			Log.d("error", errorMsg.toString());
		}

//		return successMsg.toString();
		return listSuccess;
	}

}
