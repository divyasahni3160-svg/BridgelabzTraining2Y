public class Book {
    int bookId;
    String title;
    String author;
    double price;
    public Book(int bookId,String title,String author,double price){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public static int removeDuplicate(Book[] books,int n){
        if(n==0 || n==1){
            return n;
        }
        int uniqId=0;
        for(int i=0;i<n-1;i++){
            if(books[i].bookId!=books[i+1].bookId){
                books[uniqId]=books[i];
                uniqId++;
            }
        }
        books[uniqId] = books[n - 1];
        uniqId++;
        return uniqId;
    }
    public static void searchByTitle(Book[] books, int count, String query){
        query=query.toLowerCase();
        for(int i=0;i<count;i++){

            if( books[i].title.toLowerCase().contains(query)){
                System.out.println("found "+books[i].bookId+" "+books[i].title+" "+books[i].price);
            }
        }
    }
    public static void sortByPrice(Book[] books, int count){
        int swapc=0;
        for(int i=0;i<count-1;i++){
           int minIdx=i;
            for(int j=i+1;j<count;j++){
                if(books[j].price<books[minIdx].price){
                    minIdx=j;

                }
            }int temp=books[minIdx].price;
            books[minIdx].price=books[i].price;
            books[i].price=temp;
           swapc++;
        } System.out.println(swapc);
    }
    public static int searchByPrice(Book[] books, int count, double targetPrice){
        int left=0;
        int right=count-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(books[mid].price<targetPrice){
                left=mid+1;
            } else if (books[mid].price>targetPrice) {
                right=mid-1;
            } else if (books[mid].price==targetPrice) {
                return mid;
            }
        }
        return -1;
    }
    public static int minBooksForTargetCost(Book[] books, int count, double targetCost){
        int minlength=Integer.MAX_VALUE;
        int left=0;
        double currentsum=0.0;
        for(int right=0;right<count;right++){
            currentsum+=books[right].price;
            while(currentsum>=targetCost){
                int currentLength=right-left+1;
                if(currentLength<minlength){
                    minlength=currentLength;
                }

            currentsum-=books[left].price;
            left++;
        }}
        if(minlength==Integer.MAX_VALUE){
            return 0;
        }
        return  minlength;
    }
}
