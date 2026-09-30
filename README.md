# Jogo de Adivinhação

Projeto desenvolvido para a aula de Mobile, com o objetivo de praticar a navegação entre Activities e o envio de informações usando Intent.

## Sobre o projeto

O jogo possui duas telas.

Na primeira tela, o jogador coloca seu nome e escolhe até qual número quer jogar: **10, 50 ou 100**.

Depois de clicar em **JOGAR**, o aplicativo abre a segunda tela e envia o nome e o limite escolhido.

Na segunda tela, é sorteado um número e o jogador precisa tentar adivinhar.

O jogo informa se o número está **Quente ou Frio** e também se o número correto é **Maior ou Menor** que o palpite.

Quando o jogador acerta, aparece a quantidade de tentativas.

## Tecnologias

* Kotlin
* Android Studio
* XML
* Android SDK

## O que foi utilizado

* `Intent`
* `startActivity()`
* `putExtra()`
* `getStringExtra()`
* `getIntExtra()`
* `Random`
* `finish()`
* Activities
* EditText
* Button
* TextView
* RadioButton

## Como funciona

### Tela inicial

O jogador:

1. Digita o nome.
2. Escolhe o limite.
3. Clica em **JOGAR**.

As informações são enviadas para a próxima tela usando `Intent`.

### Tela do jogo

O aplicativo sorteia um número dentro do limite escolhido.

O jogador digita seus palpites e recebe as dicas:

* **Quente** — o palpite está próximo.
* **Frio** — o palpite está mais distante.
* **MAIOR** — o número correto é maior que o palpite.
* **MENOR** — o número correto é menor que o palpite.

Quando acertar, o jogo mostra o número de tentativas e libera o botão **JOGAR DE NOVO**.

## Estrutura

```text
JogoAdivinhacao
│
├── MainActivity.kt
├── JogoActivity.kt
│
├── activity_main.xml
├── activity_jogo.xml
│
└── AndroidManifest.xml
```

## Autor

**Lucas Crippa**

Projeto desenvolvido para a disciplina de Mobile.
