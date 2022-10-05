import java.util.Scanner;

class Lista {
   private int[] array;
   private int n;

   public Lista() {
      this(6);
   }

   public Lista(int tamanho) {
      array = new int[tamanho];
      n = 0;
   }

   public void inserirFim(int x) throws Exception {

      if (n >= array.length) {
         throw new Exception("Erro ao inserir!");
      }

      array[n] = x;
      n++;
   }

   public void inserir(int x, int pos) throws Exception {

      if (n >= array.length || pos < 0 || pos > n) {
         throw new Exception("Erro ao inserir!");
      }

      for (int i = n; i > pos; i--) {
         array[i] = array[i - 1];
      }

      array[pos] = x;
      n++;
   }

   public int remover(int pos) throws Exception {

      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }

      int resp = array[pos];
      n--;

      for (int i = pos; i < n; i++) {
         array[i] = array[i + 1];
      }

      return resp;
   }

   public void mostrar() {
      System.out.print("[ ");
      for (int i = 0; i < n; i++) {
         System.out.print(array[i] + " ");
      }
      System.out.println("]");
   }

   public boolean pesquisar(int x) {
      boolean retorno = false;
      for (int i = 0; i < n && retorno == false; i++) {
         retorno = (array[i] == x);
      }
      return retorno;
   }
}

public class cassino {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = 1, k = 1, m = 1, funcionario1, funcionario2;
      while (!(N == 0 && k == 0 && m == 0)) {
         N = sc.nextInt();
         k = sc.nextInt();
         m = sc.nextInt();
         funcionario1 = k - 1;
         funcionario2 = N - m;
         int aux1 = 0, aux2 = 0;

         Lista cassino = new Lista(N);
         try {
            for (int i = 1; i <= N; i++) {
               cassino.inserirFim(i);
               // cassino.mostrar();
            }
            while(funcionario1 >= N){
               funcionario1 -= N;
            }
            while(funcionario2 < 0){
               funcionario2 += N;
            }
            while(N > 0){
               if(funcionario1 > funcionario2){
                  System.out.print("  " + cassino.remover(funcionario1));
                  System.out.print("  " + cassino.remover(funcionario2));
                  aux1 = funcionario1 + k - 2;
                  aux2 = funcionario2 - m;
                  N--;
                  N--;
               }else{
                  if(funcionario1 < funcionario2){
                     int x = cassino.remover(funcionario2);
                     int y = cassino.remover(funcionario1);
                     System.out.print("  " + y);
                     System.out.print("  " + x);
                     aux1 = funcionario1 + k - 1;
                     aux2 = funcionario2 - m - 1;
                     N--;
                     N--;
                  }else{
                     System.out.print("  " + cassino.remover(funcionario1));
                     aux1 = funcionario1 + k - 1;
                     aux2 = funcionario2 - m;
                     N--;
                  }
               }
               funcionario1 = aux1;
               funcionario2 = aux2;
               if(N > 0){
                  System.out.print(",");
                  while(funcionario1 >= N){
                     funcionario1 -= N;
                  }
                  while(funcionario2 < 0){
                     funcionario2 += N;
                  }
               }
            }

         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
      }

      sc.close();
   }
}