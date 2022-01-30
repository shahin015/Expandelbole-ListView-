package shahin.project.expandelbolelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;

    List<String>listDataHeader;
    HashMap<String,List<String>>listDatachild;

    private  CustomAdaptar customAdaptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list_data_making();

        expandableListView=findViewById(R.id.expandellistview);

        customAdaptar=new CustomAdaptar(this,listDataHeader,listDatachild);
        expandableListView.setAdapter(customAdaptar);



        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                String groupename=listDataHeader.get(i);
                Toast.makeText(getApplicationContext(), ""+groupename, Toast.LENGTH_SHORT).show();


                return false;
            }
        });



        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {

                String groupename=listDataHeader.get(i);
                Toast.makeText(getApplicationContext(), groupename+"Collapse", Toast.LENGTH_SHORT).show();

            }
        });


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {


                String childclik=listDatachild.get(listDataHeader.get(i)).get(i1);
                Toast.makeText(getApplicationContext(), ""+childclik, Toast.LENGTH_SHORT).show();

                return false;
            }
        });


    }

    private void list_data_making()
    {

        String []headerstring=getResources().getStringArray(R.array.abbrevition_list_header);
        String [] childString=getResources().getStringArray(R.array.abbrevition_list_child);

        listDataHeader=new ArrayList<>();
        listDatachild=new HashMap<>();


        for (int i=0; i<headerstring.length; i++)
        {
            listDataHeader.add(headerstring[i]);
            List<String>child=new ArrayList<>();
            child.add(childString[i]);
            listDatachild.put(listDataHeader.get(i),child);



        }




    }
}