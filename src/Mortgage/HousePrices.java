package Mortgage;

// HousePrices class inin Users dan miras aldığını unutmalayım.

public class HousePrices extends Users {
    private int price;

    public HousePrices(String username, String whichCondtiton, String houseType, int roomCount, int downPayment, int longTerm, StatesTax statesTax) {
        super(username, whichCondtiton, houseType, roomCount, downPayment, longTerm, statesTax);
        roomCountToPrice();
        conditionToPrice();
        houseTypeToPrice();
        calculateTax();
        getPriceEachMonth();

       /* Daha sonra ise satilacak evin ücretlerini hesaplamamiz icin gerekli methodlari da constructor icerisinde calistirmaliyiz.

        Ücreti hesaplarken evdeki oda sayisina, ev tipine, vb. göre ayarliyacağız. Yani... suanlik ücreti hesaplama methodlarimizi yazalim ve
        daha sonra constructor icerisinde calistiralim.*/
    }

    public int getPriceTotal() {

        return price;
    }

    public int getPriceEachMonth() {
        return (getPrice() - getDownPayment())/getLongTerm();
         /*

        Toplam ay başına düşen ücreti hesaplamak icin bir method yazmalıyız. Adina getPriceEachMonth() diyebiliriz.
        -Return tipi int olmalıdır.
        -Parametreye gerek yok.


        Ay başına düşen toplam ücret hesaplanirken, int longTerm yani vade süresine bölmeliyiz, tabi onden önce de
        peşinati ana paradan cikarmayi unutmayalim... (peşinat = downPayment)

    */


    }

    private void roomCountToPrice() {
        switch (getRoomCount()) {
            case 0:
            case 2:
                this.price += 10000;
                break;
            case 1:
                this.price += 20000;
                break;
            case 3:
                this.price += 40000;
                break;
            case 4:
                this.price += 50000;
                break;
            case 5:
                this.price += 60000;
                break;
        }
       /* Evdeki ücreti belirlerken oda sayisina dikkat etmeliyiz.
                Bunun icin  adinda bir method oluşturalim
                - Return tipi void
        - Parametre almiyacak
        Bu method icerisindeki tanimlamalarimiz su sekilde olmalidir


                (int roomCount attribute u burada kullanılacak)
        -Eğer 0 odaya sahipse ev ücreti 10000 artmalı,
                - 1 oda icin 20000 artmalı
                - 2 oda icin 30000 artmalı
                - 3 oda icin 40000 artmalı
                - 4 oda icin 50000 artmalı
                - 5 oda icin 60000 artmalı*/

    }

    private void conditionToPrice() {
        switch (getWhichCondtiton().toLowerCase()) {
            case "new":
                this.price += 50000;
                break;
            case "like new":
                this.price += 40000;
                break;
            case "old":
                this.price += 30000;
                break;
            case "renew required":
                this.price += 15000;
                break;

        }
    }

    private void houseTypeToPrice() {
        /*

        Evin tipine göre de bir hesaplama methodumuz olmalı... Bu methoda ise houseTypeToPrice() adini verebiliriz.
            - Return tipi void
            - Parametre kullanılmayacak

        (String houseType attribute u burada kullanılacak)
            - Eğer ki evin tipi "apartment" ise ücreti 20000 artacak,
            - Eğer ki evin tipi "condo" ise ücreti 30000 artacak,
            - Eğer ki evin tipi "house" ise ücreti 40000 artacak

     */
        switch (getHouseType().toLowerCase()) {
            case "apartment":
                this.price += 20000;
                break;
            case "condo":
                this.price += 30000;
                break;
            case "house":
                this.price += 40000;
                break;
        }
    }

    public void calculateTax() {
        /*

        Öncelikle conditionToPrice() adinda bir method acalim,
            - Return tipi void
            - Parametre olmayacak

     Bu methodun amacina gelirsek... Evin bir kondisyonu olmalı, yani kaç yıllık olduğu gibi bir değer verilmeli...

    (String whichCondition attribute'u burada kullanilacak.)
    Fakat burada farkli bir şekilde yapacağız.
        -Eğer ki evin kondisyonu "new" ise, ücreti 50000 artacak,
        -Eğer ki evin kondisyonu "like new" ise, ücreti 40000 artacak,
        -Eğer ki evin kondisyonu "old" ise, ücreti 30000 artacak,
        -Eğer ki evin kondisyonu "renew required" ise, ücreti 15000 artacak

     */
        price += getPriceTotal() * (getStatesTax().getTax()) / 100;
    }

    public int getPrice() {
        return price;
    }


}
     /*

        Vergiyi hesaplayan bir method yazalım adi calculateTax() olabilir.
        -Return tipi yok
        -Parametre olmayacak

        vergiyi bulmanın formulü = (toplam para * vergi miktari) * 100

   */
   /*

        HousesPrices class inin sadece bir attribute u vardir ve private dır, bu int sınıfından olmalıdır,
    değişken adına "price" diyebilirsiniz.

     */

    //--------------------------------------------------------------
    // -> Attributes
    //--------------------------------------------------------------










    /*

        Bir constructor tanimlayalim, ebeveyn sinifin tüm attributelarini parametresinde alsın ve super anahtari ile
    eşitleyebilsin.

    Daha sonra ise satilacak evin ücretlerini hesaplamamiz icin gerekli methodlari da constructor icerisinde calistirmaliyiz.

    Ücreti hesaplarken evdeki oda sayisina, ev tipine, vb. göre ayarliyacağız. Yani... suanlik ücreti hesaplama methodlarimizi yazalim ve
    daha sonra constructor icerisinde calistiralim.


    --------------

    Eğer ki tüm hesaplama methodlarini ayarladiysaniz, constuctor icerisinde sırasıyla calistirmai unutmayin...

    ipucu = vergi hesaplama methodunu en başta calistirirsaniz, hesabiniz doğru bir şekilde olmayacaktır...

     */

    //--------------------------------------------------------------
    // ->Constructor
    //--------------------------------------------------------------




    //--------------------------------------------------------------
    // -> Method
    //--------------------------------------------------------------


   /*

        Ücreti döndüren basit bir getter method yazalim cünkü price attribute un access i private.

    */
