# LargePrimalityTest
Test for large prime numbers.
-------------------------------
It can test for arbritarily large prime number by trying to find possible factors.

Command Line Argument to run jar file after entering the directory: ``Java -jar PrimalityTest.jar``

I have tried to make it efficient. It tests for large numbers within seconds.

For numbers larger than Long.MAX_VALUE: +9,223,372,036,854,775,807 (~9.2E), it is significantly slower as it needs to be converted to immutable BigInteger object and calculated using it. Program accepts integers in standard notation without commas. Console also displays additional information when running.

| Will Include       | Console       | GUI   |
| ------------------ |:-------------:| -----:|
| Source file(s)     |    &#9745;    |&#9745;|
| Binary File(s)     |    &#9745;    |&#9745;|
| Runnable Jar File  |               |&#9745;|

