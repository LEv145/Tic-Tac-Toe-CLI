package com.company;

import java.lang.*;
import java.util.Scanner;
import java.io.IOException;


public class Main {

	// Поле
	static char[][] pole = new char[][]{
			new char[] {'*', '*', '*'},
			new char[] {'*', '*', '*'},
			new char[] {'*', '*', '*'},

		};

	// Переменная игры
	static boolean gameover = true;

	// Очки
	static int player1_balls = 0;
	static int player2_balls = 0;

	// Плохой ход
	static boolean bad_move = false;

	// Переменные для указания на изменяемую клетку
	static int x = 0;
	static int y = 0;

	static boolean first = true;// Переменная, которая поможет показать пример ровно 1 раз


	// Главная функция
	public static void main(String[] args) {
		clear();
		Scanner input = new Scanner(System.in);
		

		// Цикл игры
		while (gameover){
			
			// Цикл проврки на правельный номер
			do{
				pole();
				if (first == true){
					System.out.print("игрок1, виберите координату поля (пример a1): ");
					first = false;
				}else{
					System.out.print("игрок1, виберите координату поля: ");
				}
				String player1_input = input.nextLine();

				// Выход из игры
				if (player1_input.equals("exit")){
					clear();
					System.out.print("Конец игры!");
					gameover = false;
					return;
				}
				// Перевод значиний пользоватеня в понятные для игры
				int[] player1_value = processing(player1_input);
				x = player1_value[0];
				y = player1_value[1];
				clear();
			}while (bad_move);
			pole[x][y] = 'x'; // Знак для игрока 1
			check();


			do{
				pole();
				System.out.print("игрок2, виберите координату поля: ");
				String player2_input = input.nextLine();

				if (player2_input.equals("exit")){
					clear();
					System.out.print("Конец игры!");
					gameover = false;
					return;
				}

				int[] player2_value = processing(player2_input);
				x = player2_value[0];
				y = player2_value[1];
				clear();
			}while (bad_move);
			pole[x][y] = 'o';// Знак для игрока 2
			check();
			
			
		}
		
		
	}

	// Рисование поля
	public static void pole(){
		System.out.println("Счёт: " + player1_balls + ":" + player2_balls);
		System.out.println("    1   2   3");
		char[] num = new char[]{'a','b','c'};
		for (int i = 0; i < 3; i++){
			System.out.print(num[i]);
			for (int j = 0; j < 3; j++){
				System.out.print(" | " + pole[i][j]);
			}
			System.out.println(" |");
		}

	}

	// Очистка поля
	public static void clear_pole(){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				pole[i][j] = '*';
			}
		}

	}

	// Перевод из входа пользованеля в пересенные player_x, player_y
	public static int[] processing(String player_input){
		int player_x = 0;
		int player_y = 0;
		bad_move = false;

		if (player_input.equals("a1") == true && pole[0][0] == '*'){
			player_x = 0;
			player_y = 0;
		}else if(player_input.equals("a2") == true && pole[0][1] == '*'){
			player_x = 0;
			player_y = 1;
		}else if(player_input.equals("a3") == true && pole[0][2] == '*'){
			player_x = 0;
			player_y = 2;
		}else if(player_input.equals("b1") == true && pole[1][0] == '*'){
			player_x = 1;
			player_y = 0;
		}else if(player_input.equals("b2") == true && pole[1][1] == '*'){
			player_x = 1;
			player_y = 1;
		}else if(player_input.equals("b3") == true && pole[1][2] == '*'){
			player_x = 1;
			player_y = 2;
		}else if(player_input.equals("c1") == true && pole[2][0] == '*'){
			player_x = 2;
			player_y = 0;
		}else if(player_input.equals("c2") == true && pole[2][1] == '*'){
			player_x = 2;
			player_y = 1;
		}else if(player_input.equals("c3") == true && pole[2][2] == '*'){
			player_x = 2;
			player_y = 2;
		}else{

			System.out.println("Не правельно введён номер!");
			bad_move = true;

		}


		int[] value = new int[]{player_x,player_y};

		return value;


	}

	// Проверка на выйгрыш
	public static void check(){
			boolean win_player1 = false;
			boolean win_player2 = false;


			if (pole[0][0] == 'x' && pole[1][0] == 'x' && pole[2][0] == 'x'){
				win_player1 = true;
			}else if (pole[0][1] == 'x' && pole[1][1] == 'x' && pole[2][1] == 'x'){
				win_player1 = true;
			}else if (pole[0][2] == 'x' && pole[1][2] == 'x' && pole[2][2] == 'x'){
				win_player1 = true;
			}else if (pole[0][0] == 'x' && pole[0][1] == 'x' && pole[0][2] == 'x'){
				win_player1 = true;
			}else if (pole[1][0] == 'x' && pole[1][1] == 'x' && pole[1][2] == 'x'){
				win_player1 = true;
			}else if (pole[2][0] == 'x' && pole[2][1] == 'x' && pole[2][2] == 'x'){
				win_player1 = true;
			}else if (pole[0][0] == 'x' && pole[1][1] == 'x' && pole[2][2] == 'x'){
				win_player1 = true;
			}else if (pole[2][0] == 'x' && pole[1][1] == 'x' && pole[0][2] == 'x'){
				win_player1 = true;
			}else{
				win_player1 = false;
			}

			if (pole[0][0] == 'o' && pole[1][0] == 'o' && pole[2][0] == 'o'){
				win_player2 = true;
			}else if (pole[0][1] == 'o' && pole[1][1] == 'o' && pole[2][1] == 'o'){
				win_player2 = true;
			}else if (pole[0][2] == 'o' && pole[1][2] == 'o' && pole[2][2] == 'o'){
				win_player2 = true;
			}else if (pole[0][0] == 'o' && pole[0][1] == 'o' && pole[0][2] == 'o'){
				win_player2 = true;
			}else if (pole[1][0] == 'o' && pole[1][1] == 'o' && pole[1][2] == 'o'){
				win_player2 = true;
			}else if (pole[2][0] == 'o' && pole[2][1] == 'o' && pole[2][2] == 'o'){
				win_player2 = true;
			}else if (pole[0][0] == 'o' && pole[1][1] == 'o' && pole[2][2] == 'o'){
				win_player2 = true;
			}else if (pole[2][0] == 'o' && pole[1][1] == 'o' && pole[0][2] == 'o'){
				win_player2 = true;
			}else{
				win_player2 = false;
			}

			// Добавление очка
			if (win_player1 == true){
				player1_balls++;
				clear_pole();
				
			}


			if (win_player2 == true){
				player2_balls++;
				clear_pole();
				
			}

		}

	// Очистка терминала
	public static void clear(){
		System.out.println ("\u001b[2J"); 
	}

}
