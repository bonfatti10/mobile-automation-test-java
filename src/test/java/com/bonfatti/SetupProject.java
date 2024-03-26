package com.bonfatti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SetupProject {

    // Método para instalar o Maven
    public static void installMaven() {
        try {
            Process mavenProcess = Runtime.getRuntime().exec("mvn --version");
            int mavenExitCode = mavenProcess.waitFor();
            System.out.println("Você já possui Maven instalado.");
            if (mavenExitCode != 0) {
                // Instalar o Maven caso não esteja instalado
                Process installMavenProcess = Runtime.getRuntime().exec("mvn install");
                int installMavenExitCode = installMavenProcess.waitFor();
                if (installMavenExitCode != 0) {
                    throw new RuntimeException("Erro ao instalar o Maven.");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro durante a verificação e instalação do Maven.");
        }
    }

    // Método para instalar o Appium
    public static void installAppium() {
        try {
            Process appiumProcess = Runtime.getRuntime().exec("appium --version");
            int appiumExitCode = appiumProcess.waitFor();
            System.out.println("Você já possui Appium instalado.");
            if (appiumExitCode != 0) {
                // Instalar o Appium caso não esteja instalado
                Process installAppiumProcess = Runtime.getRuntime().exec("npm install -g appium@2.5.1");
                int installAppiumExitCode = installAppiumProcess.waitFor();
                if (installAppiumExitCode != 0) {
                    throw new RuntimeException("Erro ao instalar o Appium.");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro durante a verificação e instalação do Appium.");
        }
    }

    // Método para instalar os drivers necessários
    public static void installDrivers() {
        try {
            Process uiautomatorProcess = Runtime.getRuntime().exec("npm ls -g appium-uiautomator2-driver");
            Process xcuitestProcess = Runtime.getRuntime().exec("npm ls -g appium-xcuitest-driver");

            int uiautomatorExitCode = uiautomatorProcess.waitFor();
            int xcuitestExitCode = xcuitestProcess.waitFor();
            System.out.println("Você já possui os drivers instalados.");
            if (uiautomatorExitCode != 0) {
                // Instalar o driver uiautomator2
                Process installUiautomatorProcess = Runtime.getRuntime().exec("npm install -g appium-uiautomator2-driver");
                int installUiautomatorExitCode = installUiautomatorProcess.waitFor();
                if (installUiautomatorExitCode != 0) {
                    throw new RuntimeException("Erro ao instalar o driver uiautomator2.");
                }
            }

            if (xcuitestExitCode != 0) {
                // Instalar o driver xcuitest
                Process installXcuitestProcess = Runtime.getRuntime().exec("npm install -g appium-xcuitest-driver");
                int installXcuitestExitCode = installXcuitestProcess.waitFor();
                if (installXcuitestExitCode != 0) {
                    throw new RuntimeException("Erro ao instalar o driver xcuitest.");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro durante a verificação e instalação dos drivers uiautomator2 e xcuitest.");
        }
    }

    // Método para verificar se o Appium está em execução
    public static boolean isAppiumRunning() {
        try {
            Process process = Runtime.getRuntime().exec("pgrep -f \"node .*appium\"");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();
            return (line != null && !line.isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para iniciar o Appium
    public static void startAppium() {
        try {
            Process process = Runtime.getRuntime().exec("appium");
            System.out.println("Appium iniciado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao iniciar o Appium.");
        }
    }

    // Método para encerrar o Appium
    public static void stopAppium() {
        try {
            // Encerra o processo do Appium
            ProcessBuilder builder = new ProcessBuilder("pkill", "appium");
            builder.redirectErrorStream(true);
            Process appiumProcess = builder.start();
            // Espera até que o processo seja encerrado
            appiumProcess.waitFor();

            // Verifica se o processo foi encerrado corretamente
            if (!isAppiumRunning()) {
                System.out.println("Appium encerrado com sucesso.");
            } else {
                // Caso o processo ainda esteja ativo, tenta encerrá-lo forçadamente
                ProcessBuilder forceKillBuilder = new ProcessBuilder("pkill", "-9", "-f", "appium");
                forceKillBuilder.redirectErrorStream(true);
                Process forceKillProcess = forceKillBuilder.start();
                forceKillProcess.waitFor();

                // Verifica novamente se o processo foi encerrado
                if (!isAppiumRunning()) {
                    System.out.println("Appium encerrado com sucesso.");
                } else {
                    throw new RuntimeException("Falha ao encerrar o Appium.");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao encerrar o Appium.");
        }

    }
}

