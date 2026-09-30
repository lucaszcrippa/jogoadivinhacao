# Jogo de Adivinhação

Projeto da Aula 15 — Navegação entre Activities e Transferência de Dados.

## Tecnologias
- Kotlin
- Android Studio
- XML Views
- Intent
- putExtra()
- getStringExtra()
- getIntExtra()
- Random.nextInt()
- finish()

## Funcionamento
1. O jogador informa o nome.
2. Escolhe o limite: 10, 50 ou 100.
3. O app abre a JogoActivity usando Intent.
4. O nome e o limite são enviados com putExtra().
5. A segunda Activity recebe os dados.
6. O número secreto é sorteado.
7. O jogador recebe dicas de Quente/Frio e Maior/Menor.
8. Ao acertar, o número de tentativas é exibido.
9. O botão Jogar de Novo usa finish() para retornar à primeira tela.
