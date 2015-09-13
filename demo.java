package GIS_processing;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by God
 */
public class Demo {


    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String query = reader.readLine();
        AtomicInteger query_type = new AtomicInteger();
        query_type.set(1);
        switch (query_type.get())
           {
               //type 1
               case 1:
                   if( type_check(query, query_type.get()) == true)
                   {
                       System.out.println("Syntax of your query is correct !!!");
                       System.exit(0);
                   }
                   else {
                       query_type.set(2);
                   }
                //type 2
               case 2:
                   if( type_check(query, query_type.get()) == true)
                   {
                       System.out.println("Syntax of your query is correct !!!");
                       break;
                   }
                   else {
                       System.out.println("Wrong Syntax ");
                       System.exit(0);
                   }
           }

    }

    public static boolean type_check(String query, int type)
    {
        AtomicInteger current_state = new AtomicInteger(0);
        StringTokenizer st = new StringTokenizer(query," ");
        while (st.hasMoreTokens() && type ==1) {
            switch (current_state.get()) {
                case 0:

                    if (find_next(st.nextToken(), current_state.get()) == true) {
                        current_state.set(1);
                        break;
                    }
                    else return (current_state.get() == 6);
                case 1:
                    if (find_next(st.nextToken(), current_state.get()) == true) {
                        current_state.set(2);
                        break;
                    }
                    else return (current_state.get() == 6);
                case 2:
                    if (find_next(st.nextToken(), current_state.get()) == true) {
                        current_state.set(3);
                        break;
                    }
                    else return (current_state.get() == 6);
                case 3:
                    if (find_next(st.nextToken(), current_state.get()) == true) {
                        current_state.set(4);
                        break;
                    }
                    else return (current_state.get() == 6);
                case 4:
                    if (find_next(st.nextToken(), current_state.get()) == true) {
                        current_state.set(5);
                        break;
                    }
                    else return (current_state.get() == 6);
                case 5:
                    if (find_next(st.nextToken(), current_state.get()) == true) {
                        current_state.set(6);
                        break;
                    }
                    else return (current_state.get() == 6);

            }

        }
        while (st.hasMoreTokens() && type ==2) {
            switch (current_state.get()) {
                case 0:
                    if (find_next(st.nextToken(), current_state.get()) == true) {
                        current_state.set(3);
                        break;
                    }
                    else return (current_state.get() == 6);
                case 1:
                    if (find_next(st.nextToken(), current_state.get()) == true) {
                        current_state.set(4);
                        break;
                    }
                    else return (current_state.get() == 6);
                case 3:
                    if (find_next(st.nextToken(), current_state.get()) == true) {
                        current_state.set(1);
                        break;
                    }
                    else return (current_state.get() == 6);
                case 4:
                    if (find_next(st.nextToken(), current_state.get()) == true) {
                        current_state.set(5);
                        break;
                    }
                    else return (current_state.get() == 6);
                case 5:
                    if (find_next(st.nextToken(), current_state.get()) == true) {
                        current_state.set(6);
                        break;
                    }
                    else return (current_state.get() == 6);

            }

        }
        return (current_state.get() == 6);
    }
    //find_next(current_state, next_word_in_query)
    public static boolean find_next(String token, int current_state){

        //the lookup Table
        String[][] lookup_table;
        lookup_table = new String[][]{
                {"Where","What","Which"},
                {"is","are"},
                {"the","a","to","of"},
                {"places","rivers","districts","colleges","hostels","place"},
                {"near","nearest","above","below","west","east","northeast","north","south"},
                {"jorhat","JEC"}
        };
        for(int j=0; j<lookup_table[current_state].length; j++)
        {

            if( token.equalsIgnoreCase(lookup_table[current_state][j]))
            {
                return true;
            }

        }
        return false;

    }
}
