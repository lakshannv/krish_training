# Missing Number finder

## Write a program to find the missing number of the given **n, n + 1, n + 2 ...** sequence.
### Rules
- Input numbers must be sepatated by a delimiter
- Assume the input number series is unsorted.
- If there is more than one missing number, it's an invalid series and the user must be informed.

### Example

If we want to find the missing number from the unsorted series "7 6 2 4 9 1 8 3", it would look for the missing number and will show it in the console.

![Example](https://i.ibb.co/K9n0yNb/1.png)

### First or Last Missing numbers
If the number series seems to be complete, that means the missing number is either the one before the first number, or the one after the last number.

![Example](https://i.ibb.co/FBHZ8kF/1.png)

### More than one Missing numbers
If the number series contains more than one missing number, then the number series is invalid and a message is shown to the user.

![Example](https://i.ibb.co/kXZMqQv/1.png)

### Invalid inputs by the user
if the user input does not follow the **[Number][Space][Number]...** pattern, the user is informed that all numbers should be separated by a Space delimiter.

![image](https://user-images.githubusercontent.com/79735111/156928602-bd8496e7-25ab-469c-8900-a1b3f00629b8.png)

### Test Results
![image](https://user-images.githubusercontent.com/79735111/156928506-f903d897-815a-40d7-baea-04e2d9d12adf.png)