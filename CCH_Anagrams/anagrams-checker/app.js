const regex = new RegExp("^([A-Za-z]+[ ][A-Za-z]+)$");

const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
    terminal: false
});

readline.question('Enter the 2 words :\n',
    inputText => {
        readline.close();

        if (!validate(inputText)) {
            console.log("Please enter two words seperated by a space delimiter.");
            return;
        }

        let words = inputText.toLowerCase().split(" ");
        checkIfAnagrams(words)
    });

function validate(inputText) {
    return regex.test(inputText);
}

function checkIfAnagrams(words) {
    let word1 = words[0], word2 = words[1], characterMap1 = {}, characterMap2 = {};

    if (word1.length !== word2.length) {
        console.log(`The words '${word1}' and '${word2}' are not anagrams.`);
        return;
    }

    for (let i = 0; i < word1.length; i++) {
        let character = word1.charAt(i);
        if (character in characterMap1) {
            characterMap1[character] = characterMap1[character] + 1
        } else {
            characterMap1[character] = 1;
        }
    }

    for (let i = 0; i < word2.length; i++) {
        let character = word2.charAt(i);
        if (character in characterMap2) {
            characterMap2[character] = characterMap2[character] + 1
        } else {
            characterMap2[character] = 1;
        }
    }

    if (Object.keys(characterMap1).length !== Object.keys(characterMap2).length) {
        console.log(`The words '${word1}' and '${word2}' are not anagrams.`);
        return;
    }

    for (let character in characterMap1) {
        if (characterMap1[character] !== characterMap2[character]) {
            console.log(`The words '${word1}' and '${word2}' are not anagrams.`);
            return;
        }
    }
    console.log(`The words '${word1}' and '${word2}' are anagrams.`);
}