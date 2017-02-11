// RCalc: Reverse Polish Notation compute, mult-platform
// Copyright (C) 2017 Djeck

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.

package core;

import java.util.Scanner;

public class Launcher {
	public static void main(String argv[]) {
		Scanner scan = new Scanner(System.in);
		
		String cmd;
		boolean quit = false;
		Stack stack = new Stack();
		
		stack.addOperatorSet(new Standard());
		stack.addOperatorSet(new Trigonometric());
		
		do {
			System.out.print(stack.currentValue());
			System.out.print(" $ ");
			cmd = scan.nextLine();
			if(cmd.equalsIgnoreCase("quit") || cmd.equalsIgnoreCase("exit") || cmd.equalsIgnoreCase("q"))
				quit = true;
			else if(!stack.handle(cmd)) {
				System.out.println("Invalid command: "+cmd);
			}
		} while (!quit);
		scan.close();
	}
}
