# e2e-automatiion-test-java

# Projeto de Testes Mobile com Appium e JUnit

Este é um projeto de testes mobile para Android e iOS, utilizando Appium 2.2.2, JUnit Jupiter e Maven. O projeto inclui integração com Allure Report para geração de relatórios detalhados.

## Pré-requisitos

Certifique-se de ter os seguintes softwares instalados em seu sistema:

- Java Development Kit (JDK) 11 ou superior
- Maven
- Appium Server 2.2.2
- Android SDK para testes em dispositivos Android
- Xcode e iOS Simulator ou dispositivo iOS para testes em dispositivos iOS

## Configuração do Ambiente

1. Instale o JDK 11 e configure as variáveis de ambiente.
- Você pode baixar o java:
  ```bash
  brew install --cask adoptopenjdk11
  ```
- Você pode verificar a versão do java:
  ```bash
  java -version
  ```
2. Instale o Maven e configure as variáveis de ambiente.
3. Instale o Appium Server 2.5.1
- Você pode baixar o Appium a partir do npm (Node Package Manager):
  ```bash
  npm install -g appium@2.5.1
  ```
4. Configure o Android SDK e as variáveis de ambiente necessárias para testes em dispositivos Android.
5. No caso de testes em dispositivos iOS, configure o Xcode e o iOS Simulator, ou conecte um dispositivo iOS ao sistema.

## Configuração do Projeto

1. Clone este repositório para o seu ambiente local.
2. Abra o projeto em sua IDE de preferência.
3. As dependências do Maven estão configuradas corretamente no arquivo `pom.xml`.
4. Verifique as configurações do Appium no arquivo `src/test/java/com/bonfatti/Hooks.java`.
5. Configure as capacidades do dispositivo (device capabilities) no arquivo `src/test/resources/capabilities.json`.

## Execução dos Testes

Para executar os testes, siga estas etapas:

1. Abra um terminal na raiz do projeto.
2. Execute o seguinte comando:


Isso irá iniciar a execução dos testes definidos na pasta `src/test/java` utilizando o JUnit Jupiter.

## Geração de Relatórios com Allure

Este projeto está configurado para gerar relatórios detalhados com o Allure Report. Para gerar o relatório, siga estas etapas:

1. Após a execução dos testes, abra um terminal na raiz do projeto.
2. Execute o seguinte comando para gerar os relatórios:


Isso irá gerar os relatórios na pasta `allure-report` e abrirá automaticamente o relatório no seu navegador padrão.

### Autor
Carlos Bonfatti
