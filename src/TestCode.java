import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestCode {
    public static void main(String[] args) {

        String funcName = null;

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            funcName = br.readLine();
        }catch (IOException e){
            System.out.println("io exception");
        }

        try{
            Object obj = new TestCode();
            Class<?> cls = Class.forName(obj.getClass().getName());
            Method m = cls.getDeclaredMethod(funcName);
            m.invoke(obj);
        }catch (ClassNotFoundException e){
            System.out.println("class not found");
        }catch (NoSuchMethodException e){
            System.out.println("no such method");
        }catch (InvocationTargetException e){
            System.out.println("invocationTargetException");
        }catch (IllegalAccessException e){
            System.out.println("illegalAccessException");
        }

    }


    public void test10869() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);

        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();

        scanner.close();

        writer.write((a+b) + "\n");
        writer.write((a-b) + "\n");
        writer.write((a*b) + "\n");
        writer.write((a/b) + "\n");
        writer.write((a%b) + "\n");

        writer.flush();
        writer.close();
    }

    public void test2588() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();

        br.close();

        System.out.println(a * (b.charAt(2) - '0'));
        System.out.println(a * (b.charAt(1) - '0'));
        System.out.println(a * (b.charAt(0) - '0'));
        System.out.println(a * Integer.parseInt(b));
    }

    public void test2753() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        if((a % 4 == 0 && a % 100 != 0 ) || a % 400 == 0){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }

    public void test10871() throws IOException {
        /**
         * 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N,X,A;
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A = Integer.parseInt(str.nextToken());
            if (A < X){
                sb.append(A).append(" ");
            }
        }
        System.out.println(sb);
    }

    public void test8958_1() throws IOException{
        /**
         * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
         * 배열 사용 X
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int cnt;
        int sum;
        for (int i = 0; i < n; i++) {
            cnt = 0;
            sum = 0;
            for (byte value : br.readLine().getBytes()) {
                if (value == 'O'){
                    cnt++;
                    sum += cnt;
                }
                else{
                    cnt = 0;
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }

    public void test8958_2() throws IOException {
        /**
         * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
         * 배열 사용
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] questions = new String[n];
        int cnt;
        int sum;
        for (int i = 0; i < n; i++){
            questions[i] = br.readLine();
            cnt = 0;
            sum = 0;
            for (int j = 0; j < questions[i].length(); j++){
                if (questions[i].charAt(j) == 'O'){
                    cnt++;
                    sum += cnt;
                }else{
                    cnt = 0;
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }

    public void test4344() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] scores;

        for (int i = 0; i < C; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            double sum = 0;
            scores = new int[N];
            for (int j = 0; j < N; j++){
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }
            double average = (sum / N);
            double count = 0;

            for (int j = 0; j < N; j++){
                if (scores[j] > average){
                    count++;
                }
            }
            System.out.printf("%.3f%%%n", (count/N)*100);
        }
    }

    public void test11654() throws Exception{
        /**
         * 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
         */
        int a = System.in.read();
        System.out.println(a);

    }

    public void test1152() throws IOException{
        /**
         * split() 함수를 사용하는 경우 -> 공백이 들어오면 1로 arr.length가 1로 반환된다.
         * split 함수를 뜯어보면 매칭되는 정규식이 없을 경우 자기 자신을 반환하게 되어있다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(st.countTokens());
    }

    public void test2869() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int days = (length - down) / (up - down);
        if ((length - down) % (up - down) != 0) {
            days++;
        }
        System.out.println(days);
    }

    public void test1978() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            if (isPrime(Integer.parseInt(st.nextToken()))){
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isPrime(int num){
        if (num == 1 ) return false;

        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0) return false;
        }

        return true;
    }

    public void test10872() throws Exception {
        /**
         * N! 팩토리얼 재귀함수 이용안함.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 1;
        for (int i = N; i >= 1; i--) {
            result *= i;
        }
        System.out.println(result);
    }

    public void test10872_1() throws Exception {
        /**
         * N! 팩토리얼 재귀함수
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = factorial(N);
        System.out.println(sum);
    }
    public static int factorial(int num){
        if (num <= 1 ) return 1;
        return num * factorial(num - 1);
    }


    public void test1181()  throws Exception {
        /**
         * String 길이순 정렬, 길이가 같다면 사전순으로 정렬하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String arr[] = new String[N];

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }


        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) { // compare return 양수이면 두 객체의 위치를 바꾼다. 0이나 음수인경우 바꾸지 않음.
                //단어 길이가 같을 경우
                if (s1.length() == s2.length()){
                    return s1.compareTo(s2); //compareTo : 사전순 정렬
                }
                else{
                    return s1.length() - s2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        sb.append(arr[0]).append('\n');

        for(int i = 1; i < N; i++){
            if (!arr[i].equals(arr[i-1])){
                sb.append(arr[i]).append('\n');
            }
        }

        System.out.println(sb);
    }

    public void test_11650() throws IOException {
        /**
         * 좌표 정렬하기, 이차원 배열, compare 함수를 람다식으로 작성하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //Comparator에 대해 익명 클래스를 생성할 때 compare 을 T[] 타입의 매개변수를 가진 람다식으로 바꾸어 쓸 수 있다.
        Arrays.sort(arr, (e1, e2) ->{
            if (e1[0] == e2[0]){
                return e1[1] - e2[1];
            }else{
                return e1[0] - e2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.println(sb);
    }

    public void test10989() throws IOException {
        /**
         * 메모리,시간제한이 있어 카운팅정렬로
         * 카운팅정렬은 정렬하려는 수의 범위가 클수록 비용이 많이 든다. (메모리 사용량 큼)
         * 0~10000 이니까 카운팅 정렬로
         * Arrays.sort()는 dual-pivot Quick Sort 알고리즘을 사용한다.평균 O(nlogn) 시간복잡도. 최악의 경우에는 O(n²)
         * 카운팅정렬은 O(N+K) K는 자릿수, 입력데이터가 K보다 훨씬 큰 경우, (데이터가 많으면 많을수록) O(N)에 가깝다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 정렬 하려는 수의 개수

        //정렬하려는 수의 범위 (0~10000)
        int[] arr = new int[10001];

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        //정렬하려는 수의 범위 만큼 for
        for (int i = 1; i < 10001; i++){

            //중복데이터가 있을 수 있기 때문에, arr[i] 의 값이 0이 될 때까지 반복 (빈도수)
            while(arr[i] > 0){
                sb.append(i).append('\n');
                arr[i]--;
            }
        }

        System.out.println(sb);
    }

    public void test2309() throws Exception {
        /**
         * 부르트포스 알고리즘 (전체 탐색)
         * 가능한 모든 경우의 수를 모두 탐색하면서 요구조건에 충족되는 결과만을 가져온다.
         * 예외없이 100%의 확률로 정답만을 출력한다.
         * 정렬
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        int fake1 = 0, fake2 = 0;
        for (int i = 0 ; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        for (int i = 0 ; i < 9; i++) {
            for (int j = i + 1 ; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100){
                    fake1 = arr[i];
                    fake2 = arr[j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < 9; i++){
            if (fake1 == arr[i] || fake2 == arr[i])
                continue;
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);

    }


}
