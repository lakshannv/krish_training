const regex = new RegExp("^(-?\\d+ ?)+$");

const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
    terminal: false
});

readline.question('Enter the (space separated) number series :\n',
    inputText => {
        readline.close();

        if (!validate(inputText)) {
            console.log("Input number series is invalid. Please only input numbers and separate them by one space delimiter.");
            return;
        }

        let stringArray = inputText.trim().split(" ");

        if (stringArray.length < 3) {
            console.log("Input at least 3 numbers.");
            return;
        }

        let numbers = getNumberArray(stringArray);
        findThirdLargest(numbers);
    });

function getNumberArray(stringArray) {
    return stringArray.map(n => +n);
}

function validate(inputText) {
    return regex.test(inputText);
}

function findThirdLargest(numbers) {

    let max = numbers[0];
    let secondMax = Number.MIN_SAFE_INTEGER;
    let thirdMax = Number.MIN_SAFE_INTEGER;

    for (let i = 1; i < numbers.length; i++) {
        let current = numbers[i];
        if (current > max) {
            thirdMax = secondMax;
            secondMax = max;
            max = current;
        } else if (current > secondMax) {
            thirdMax = secondMax;
            secondMax = current;
        } else if (current > thirdMax) {
            thirdMax = current;
        }
    }
    console.log(`Third largest number is : ${thirdMax}`);
}