# Pong

This repository is a final project (Java GUI) from Object-Oriented Programming Class, Teknik Informatika Universitas Padjadjaran. 

[Challenge Guidelines](challenge-guideline.md)

Pong is a reiteration of a classic and one of the first computer game 'Pong' which is made with Java as the programming language. 

## Credits
| NPM           | Name              |
| ------------- |-------------------|
| 140810180030  | Rio Sapta S.      |
| 140810180048  | Nadhifal A. R.    |
| 140810190070  | Theodorik Marcus  |

## Change log
- **[Sprint Planning](changelog/sprint-planning.md) - (9 November 2020)** 
   - Workload divisions for the team.

- **[Sprint 1](changelog/sprint-1.md) - (date from 16 until 23 November 2020)** 
   - Familiariasi dengan Java GUI + Pong
   - Building JFrame & JPanel UI buat main-menu selection

- **[Sprint 2](changelog/sprint-2.md) - (date from 23 until 30 November 2020)** 
   - Building JFrame/Grid buat main-game pong multiplayer
   - Implementasi pong multiplayer dari referensi
   - Implementasi pong singleplayer (membuat AI musuh)
   - Menghubungkan main-game dengan ui main-menu
   
- **[Sprint 3](changelog/sprint-3.md) - (date from 30 November until 7 December 2020)** 
   - Short changes 1
   - Short changes 2

## Running The App

- Build the java application by using command prompt with the command 'javac Main.java'
- Run the app by using command prompt with the command 'java Main'

## Classes Used

- Main
- AIPaddle
- Ball
- GameFrame
- GamePanel
- Paddle
- Score

UML soon.

## Notable Assumption and Design App Details

- Saat memulai app muncul UI main menu
- dapat memilih singleplayer atau multiplayer dan option pada main menu
- dapat memilih difficulties dan batasan score pada option
- saat game start:
   - Paddle (player 1) muncul di bagian kiri screen
   - Paddle (player 2) muncul di bagian kiri screen
   - Paddle (player 1&2) bergerak menggunakan key
   - Paddle (AI) bergerak mengikuti Ball
   - Paddle memiliki batas (akan menabrak) pada bagian atas dan bawah screen
   - Ball muncul di bagian tengah screen
   - Ball bergerak menuju arah yang random saat start
   - Ball berpantul saat menabrak Paddle
   - player 1 akan mendapat score ketika bola menyentuh bagian kanan screen
   - player 2 akan mendapat score ketika bola menyentuh bagian kiri screen
   - score akan di tampilkan di tengah bagian atas screen
   - game berakhir saat salah satu player mendapat score yang menjadi batasan pemenang
