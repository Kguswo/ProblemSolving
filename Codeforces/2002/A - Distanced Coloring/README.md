<h2><a href="https://codeforces.com/contest/2002/problem/A" target="_blank" rel="noopener noreferrer">2002A — Distanced Coloring</a></h2>

| | |
|---|---|
| **Difficulty** | 800 |
| **Language** | Java 21 |
| **Verdict** | ✅ Accepted |
| **Problem Link** | [Codeforces 2002A](https://codeforces.com/contest/2002/problem/A) |

## Topics
`constructive algorithms` `implementation` `math`

---

## Problem Statement

<div class="header"><div class="title">A. Distanced Coloring</div><div class="time-limit"><div class="property-title">time limit per test</div>1 second</div><div class="memory-limit"><div class="property-title">memory limit per test</div>256 megabytes</div><div class="input-file input-standard"><div class="property-title">input</div>standard input</div><div class="output-file output-standard"><div class="property-title">output</div>standard output</div></div><div><p>You received an $$$n\times m$$$ grid from a mysterious source. The source also gave you a magic positive integer constant $$$k$$$.</p><p>The source told you to color the grid with some colors, satisfying the following condition:</p><ul> <li> If $$$(x_1,y_1)$$$, $$$(x_2,y_2)$$$ are two distinct cells with the same color, then $$$\max(|x_1-x_2|,|y_1-y_2|)\ge k$$$. </li></ul><p>You don't like using too many colors. Please find the minimum number of colors needed to color the grid.</p></div><div class="input-specification"><div class="section-title">Input</div><p>Each test contains multiple test cases. The first line contains the number of test cases $$$t$$$ ($$$1\le t\le1000$$$). The description of the test cases follows.</p><p>The only line of each test case consists of three positive integers $$$n$$$, $$$m$$$, $$$k$$$ ($$$1\le n,m,k\le10^4$$$) — the dimensions of the grid and the magic constant.</p></div><div class="output-specification"><div class="section-title">Output</div><p>For each test case, print a single integer — the minimum number of colors needed to color the grid.</p></div><div class="sample-tests"><div class="section-title">Example</div><div class="sample-test"><div class="input"><div class="title">Input<div title="Copy" data-clipboard-target="#id00688823240789527" id="id0017419105756688635" class="input-output-copier">Copy</div></div><pre id="id00688823240789527"><div class="test-example-line test-example-line-even test-example-line-0">6</div><div class="test-example-line test-example-line-odd test-example-line-1">3 3 2</div><div class="test-example-line test-example-line-even test-example-line-2">5 1 10000</div><div class="test-example-line test-example-line-odd test-example-line-3">7 3 4</div><div class="test-example-line test-example-line-even test-example-line-4">3 2 7</div><div class="test-example-line test-example-line-odd test-example-line-5">8 9 6</div><div class="test-example-line test-example-line-even test-example-line-6">2 5 4</div></pre></div><div class="output"><div class="title">Output<div title="Copy" data-clipboard-target="#id008991010531260124" id="id0022785375964613763" class="input-output-copier">Copy</div></div><pre id="id008991010531260124">4
5
12
6
36
8
</pre></div></div></div><div class="note"><div class="section-title">Note</div><p>In the first test case, one of the optimal constructions is:</p><center> <img class="tex-graphics" src="https://espresso.codeforces.com/e9e19706cff1ccd9881daced2cb3b7d56e58395a.png" style="zoom: 80.0%;max-width: 100.0%;max-height: 100.0%;"> </center><p>In the second test case, the color of all cells must be pairwise different, so the answer is $$$5$$$.</p></div>