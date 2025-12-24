using System;

namespace Solution {
    class Program {
        static void Main(string[] args) {
            string input = Console.ReadLine();
        
            string[] split = input.Split(" ");
        
            Console.WriteLine(int.Parse(split[0]) + int.Parse(split[1]));
        }
    }
}