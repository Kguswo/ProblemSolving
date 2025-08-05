/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.util.*;
import java.io.*;

private lateinit var br: BufferedReader
private lateinit var bw: BufferedWriter
private var N=0
private var M=0
private lateinit var memory: IntArray
private lateinit var cost: IntArray

fun main(){
    br = BufferedReader(InputStreamReader(System.`in`))
    bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    N = n
    M = m

    memory = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    cost = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val maxCost = cost.sum()

    val dp = IntArray(maxCost+1)

    for (i in 0 until N) {
        for (j in maxCost downTo cost[i]) {
            dp[j] = maxOf(dp[j], dp[j - cost[i]] + memory[i])
        }
    }

    for (i in 0..maxCost) {
        if (dp[i] >= M) {
            println(i)
            break
        }
    }

}