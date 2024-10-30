I linje 43 kalder I 

    rollForPoint(point);

uden at bruge resultatet til noget, det gør I så i linje 44

    if (rollForPoint(point)) {

Så linje 43 kan slettes.

---

    System.out.println("Du rullede: " + 7);

er det samme som 

    System.out.println("Du rullede: 7");

bare uden String konkatenering.

---

