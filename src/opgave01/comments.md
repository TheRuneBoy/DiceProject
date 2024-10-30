I rollDice() klassen 

    for (int index = 0; index < diceRolled.length; index++)
        dice01 = (int) (Math.random() * 6 + 1);

opdatere I bare dice01 variablen 2 gange, en gang er nok, så 

    dice01 = (int) (Math.random() * 6 + 1);

er fint, så behøver I heller ikke 

    int[] diceRolled = new int[2];

---

I Updatestatistisks metoden kan 

    for (int index = 1; index <= 6; index++) {
        if (faces[0] == index) {
            numbersOnDice[index - 1]++;
        }
        if (faces[1] == index) {
            numbersOnDice[index - 1]++;
        }
    }

erstattes med 

    numbersOnDice[faces[0] - 1]++;
    numbersOnDice[faces[1] - 1]++;

---

