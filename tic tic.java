import java.util.*;
public class Gaming1{
private static char[][] Table = new char[3][3];
private static char NEWPLAYER = 'S';
private static void StartingTable() {
for (int i = 0; i < 3; i++) {
for (int j = 0; j < 3; j++) {
Table[i][j] = '_';
}
}
}
private static void printTable() {
for (int i = 0; i < 3; i++) {
System.out.print("| ");
for (int j = 0; j < 3; j++) {
System.out.print(Table[i][j] + " | ");
}
System.out.println();
}
}
private static boolean Filledtable() {
for (int i = 0; i < 3; i++) {
for (int j = 0; j < 3; j++) {
if (Table[i][j] == '_') {
return false;
}
}
}
return true;
}
private static boolean SearchingWinner() {
// Check rows
for (int i = 0; i < 3; i++) {
if (Table[i][0] == Table[i][1] && Table[i][1] == Table[i][2] && Table[i][0] != '_') {
return true;
}
}
// Check columns
for (int i = 0; i < 3; i++) {
if (Table[0][i] == Table[1][i] && Table[1][i] == Table[2][i] && Table[0][i] != '_') {
return true;
}
}
// Check diagonals
if (Table[0][0] == Table[1][1] && Table[1][1] == Table[2][2] && Table[0][0] != '_') {
return true;
}
if (Table[0][2] == Table[1][1] && Table[1][1] == Table[2][0] && Table[0][2] != '_') {
return true;
}
return false;
}
private static void NEXTPLAYER() {
if (NEWPLAYER == 'S') {
NEWPLAYER = 'O';
} else {
NEWPLAYER = 'S';
}
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
StartingTable();
System.out.println("Welcome to Tic Tac Toe!");
while (!Filledtable() && !SearchingWinner()) {
printTable();
System.out.print("Player " + NEWPLAYER + ", enter your move (row[0_2] column[0_2]): 
");
int row = scanner.nextInt();
int col = scanner.nextInt();
if (row < 0 || col < 0 || row > 2 || col > 2 || Table[row][col] != '_') {
System.out.println("Invalid move, please try again.");
} else {
Table[row][col] = NEWPLAYER;
if (SearchingWinner()) {
printTable();
System.out.println("Player " + NEWPLAYER + " wins!");
break;
}
if (Filledtable()) {
printTable();
System.out.println("It's a draw!");
break;
}
NEXTPLAYER();
}
}
scanner.close();
}
}
