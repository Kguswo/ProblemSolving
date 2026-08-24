<h2><a href="https://codeforces.com/contest/2050/problem/B" target="_blank" rel="noopener noreferrer">2050B — Transfusion</a></h2>

| | |
|---|---|
| **Difficulty** | 1100 |
| **Language** | C++17 (GCC 7-32) |
| **Verdict** | ✅ Accepted |
| **Problem Link** | [Codeforces 2050B](https://codeforces.com/contest/2050/problem/B) |

## Topics
`brute force` `greedy` `math`

---

## Problem Statement

<div class="header"><div class="title">B. Transfusion</div><div class="time-limit"><div class="property-title">time limit per test</div>2 seconds</div><div class="memory-limit"><div class="property-title">memory limit per test</div>256 megabytes</div><div class="input-file input-standard"><div class="property-title">input</div>standard input</div><div class="output-file output-standard"><div class="property-title">output</div>standard output</div></div><div><p>You are given an array $$$a$$$ of length $$$n$$$. In one operation, you can pick an index $$$i$$$ from $$$2$$$ to $$$n-1$$$ inclusive, and do one of the following actions:</p><ul> <li> Decrease $$$a_{i-1}$$$ by $$$1$$$, then increase $$$a_{i+1}$$$ by $$$1$$$.<p> </p></li><li> Decrease $$$a_{i+1}$$$ by $$$1$$$, then increase $$$a_{i-1}$$$ by $$$1$$$. </li></ul><p>After each operation, all the values must be non-negative. Can you make all the elements equal after any number of operations?</p></div><div class="input-specification"><div class="section-title">Input</div><p>First line of input consists of one integer $$$t$$$ ($$$1 \le t \le 10^4$$$)  — the number of test cases.</p><p>First line of each test case consists of one integer $$$n$$$ ($$$3 \le n \le 2\cdot 10^5$$$).</p><p>Second line of each test case consists of $$$n$$$ integers $$$a_i$$$ ($$$1 \le a_i \le 10^9$$$).</p><p>It is guaranteed that the sum of $$$n$$$ of all test cases doesn't exceed $$$2\cdot 10^5$$$.</p></div><div class="output-specification"><div class="section-title">Output</div><p>For each test case, print "<span class="tex-font-style-tt">YES</span>" without quotation marks if it is possible to make all the elements equal after any number of operations; otherwise, print "<span class="tex-font-style-tt">NO</span>" without quotation marks.</p><p>You can print answers in any register: "<span class="tex-font-style-tt">yes</span>", "<span class="tex-font-style-tt">YeS</span>", "<span class="tex-font-style-tt">nO</span>"  — will also be considered correct.</p></div><div class="sample-tests"><div class="section-title">Example</div><div class="sample-test"><div class="input"><div class="title">Input<div title="Copy" data-clipboard-target="#id008394865475501644" id="id006752443445904196" class="input-output-copier">Copy</div></div><pre id="id008394865475501644"><div class="test-example-line test-example-line-even test-example-line-0">8</div><div class="test-example-line test-example-line-odd test-example-line-1">3</div><div class="test-example-line test-example-line-odd test-example-line-1">3 2 1</div><div class="test-example-line test-example-line-even test-example-line-2">3</div><div class="test-example-line test-example-line-even test-example-line-2">1 1 3</div><div class="test-example-line test-example-line-odd test-example-line-3">4</div><div class="test-example-line test-example-line-odd test-example-line-3">1 2 5 4</div><div class="test-example-line test-example-line-even test-example-line-4">4</div><div class="test-example-line test-example-line-even test-example-line-4">1 6 6 1</div><div class="test-example-line test-example-line-odd test-example-line-5">5</div><div class="test-example-line test-example-line-odd test-example-line-5">6 2 1 4 2</div><div class="test-example-line test-example-line-even test-example-line-6">4</div><div class="test-example-line test-example-line-even test-example-line-6">1 4 2 1</div><div class="test-example-line test-example-line-odd test-example-line-7">5</div><div class="test-example-line test-example-line-odd test-example-line-7">3 1 2 1 3</div><div class="test-example-line test-example-line-even test-example-line-8">3</div><div class="test-example-line test-example-line-even test-example-line-8">2 4 2</div></pre></div><div class="output"><div class="title">Output<div title="Copy" data-clipboard-target="#id002369075721875603" id="id0044659166801240724" class="input-output-copier">Copy</div></div><pre id="id002369075721875603">YES
NO
YES
NO
YES
NO
NO
NO
</pre></div></div></div>