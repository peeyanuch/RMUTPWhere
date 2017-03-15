package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Plan extends AppCompatActivity implements View.OnClickListener {

    private ImageView bar1ImageView, bar2ImageView, bar3ImageView, bar4ImageView, bar5ImageView;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        final String name[] = {"1 อาคารอำนวยการ"
                ,"2 อาคารสำนักงานบริการ"
                ,"3 อาคารอเนกประสงค์"
                ,"4 อาคารฝึกพื้นฐานทาง วิศวกรรม"
                ,"5 อาคารวิศวอุตสาหการ"
                ,"6 อาคารช่างยนต์ ๑"
                ,"7 อาคารแผนกอัญมณี"
                ,"8 อาคารช่างกลโรงงาน"
                ,"9 อาคารอนุสรณ์ 40 ปี"
                ,"10 อาคารช่างยนต์ ๒"
                ,"11 อาคารสาขาวิศวกรรมโยธา"
                ,"12 อาคารวิศวกรรมการผลิต เครื่องมือและแม่พิมพ์"
                ,"13 อาคารเรียนและปฏิบัติการ สาขาเครื่องจักรอัตโนมัติ"
                ,"14 อาคารช่างหล่อ"
                ,"15 อาคารกิจกรรมนักศึกษา"
                ,"16 อาคารวิศวกรรมไฟฟ้า"
                ,"17 อาคารอิเล็กทรอนิกส์"};

        final Integer[] imageId = {
                R.drawable.b01,//1
                R.drawable.b03,//2
                R.drawable.b02,//3
                R.drawable.b15,//4
                R.drawable.b20,//5
                R.drawable.b05,//6
                R.drawable.b12,//7 ยังไม่ได้ถ่ายรูป
                R.drawable.b07,//8
                R.drawable.b09,//9
                R.drawable.b16,//10 ยังไม่ได้ถ่ายรูป
                R.drawable.b20,//11 ยังไม่ได้ถ่ายรูป
                R.drawable.b16,//12 ยังไม่ได้ถ่ายรูป
                R.drawable.b16,//13 ยังไม่ได้ถ่ายรูป
                R.drawable.b16,//14
                R.drawable.b19,//15
                R.drawable.b12,//16
                R.drawable.b13,//17
        };

        final String detail[] = {"อาคารอำนวยการตั้งอยู่ด้านหน้าของมหาวิทยาลัยเทคโนโลยีราชมงคลพระนคร ศูนย์พระนครเหนือ และมีพระวิษณุประดิษฐานอยู่ด้านหน้าของอาคารอำนวยการ"
                ,""
                ,"อาคารอเนกประสงค์ เป็นอาคารเรียนของสาขาวิชาวิศวกรรมแมคคาทรอนิกส์  และประกอบไปด้วยห้องสมุด ห้อง Self-Access ห้องประชุมเฟืองทอง และโรงยิม"
                ,"อาคารฝึกพื้นฐานทางวิศวกรรม เป็นการเรียนฝึกพื้นฐาน เช่น วิชาตะไบ "
                ,"อาคารวิศวอุตสาหการ เป็นอาคารเรียนของสาขาวิชาวิศวกรรมอุตสาหการ"
                ,"อาคารช่างยนต์๑ เป็นอาคารเรียนระดับปริญญาตรี สาขาวิชาวิศวกรรมเครื่องกล"
                ,"อาคารแผนกอัญมนี เป็นอาคารเรียนของสาขาวิชาเทคโนโลยีแม่พิมพ์และเครื่องประดับ"
                ,"อาคารช่างกลโรงงาน เป็นอาคารเรียนระดับ ปวช. ช่างกลโรงงาน"
                ,"อาคารอนุสรณ์40ปี เป็นอาคารของคณะวิทยาศาสตร์และเทคโนโลยี โดยภายในอาคารแบ่งการเรียนการสอนออกเป็น 3 สาขาวิชา คือ 1.สาขาวิชาวิทยาการคอมพิวเตอร์ 2.สาขาวิชาสิ่งแวดล้อมและทรัพยากรธรรมชาติ 3.สาขาวิชาวัสดุศาสตร์อุตสาหกรรม และมีการเรียนการสอนของสาขาวิชาวิศวกรรมคอมพิวเตอร์"
                ,"อาคารช่างยนต์๒ เป็นอาคารเรียนของสาขาวิชาวิศวกรรมเครื่องกล แผนกวิชาช่างยนต์ และระดับ ปวช. ช่างยนต์"
                ,"อาคารสาขาวิศวกรรมโยธา เป็นอาคารเรียนของสาขาวิชาวิศวกรรมโยธา"
                ,"อาคารวิศวกรรมการผลิตเครื่องมือและแม่พิมพ์ เป็นอาคารเรียนระดับ ปริญญาตรีของสาขาวิชาวิศวกรรมการผลิตเครื่องมือและแม่พิมพ์"
                ,""
                ,"อาคารช่างหล่อ เป็นอาคารสำหรับการเรียนการสอน วิชาวิศวกรรมงานหล่อ"
                ,"อาคารกิจกรรมนักศึกษา ประกอบด้วยห้องพักครู คณะศิลปะศาสตร์ ห้องชมรมต่างๆ ห้องแนะแนว ห้องฟิตเนต และโรงอาหาร"
                ,"อาคารวิศวกรรมไฟฟ้า เป็นอาคารเรียนระดับปริญญาตรี สาขาวิชาวิศวกรรมไฟฟ้า และ ระดับ ปวช.  ช่างไฟฟ้ากำลัง"
                ,"อาคารอิเล็กทรอนิกส์ เป็นอาคารเรียนระดับปริญญาตรี สาขาวิชาวิศวกรรมอิเล็กทรอนิกส์และโทรคมนาคม และระดับ ปวช. ช่างอิเล็กทรอนิกส์"
        };




        CustomList adapter = new CustomList(Plan.this,name,imageId);
        listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Dialog dialog = new Dialog(Plan.this);
                dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_data);
                TextView textView11 = (TextView)dialog.findViewById(R.id.textView11);
                textView11.setText(name[i]);
                TextView textView12 = (TextView)dialog.findViewById(R.id.textView12);
                textView12.setText(detail[i]);
                ImageView imageView26 = (ImageView)dialog.findViewById(R.id.imageView26);
                imageView26.setImageResource(imageId[i]);

                Button button = (Button) dialog.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                     dialog.show();

               // switch (i+1){
                  //  case 1:
                    //    setContentView(R.layout.b01);
                     //   break;
                    //case 2:
                      //  setContentView(R.layout.b02);
                      //  break;
                    //case 3:
                      //  setContentView(R.layout.b03);
                      //  break;
                   // case 4:
                      //  setContentView(R.layout.b05);
                     //   break;

                //}
            }
        });


        bar1ImageView = (ImageView) findViewById(R.id.imageView17);
        bar2ImageView = (ImageView) findViewById(R.id.imageView16);
        bar3ImageView = (ImageView) findViewById(R.id.imageView15);
        bar4ImageView = (ImageView) findViewById(R.id.imageView14);
        bar5ImageView = (ImageView) findViewById(R.id.imageView13);

        //Image Controller
        bar1ImageView.setOnClickListener(Plan.this);
        bar2ImageView.setOnClickListener(Plan.this);
        bar3ImageView.setOnClickListener(Plan.this);
        bar4ImageView.setOnClickListener(Plan.this);
        bar5ImageView.setOnClickListener(Plan.this);




    }

      @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageView17:
                startActivity(new Intent(Plan.this, MainActivity.class));
                break;
            case R.id.imageView16:
                startActivity(new Intent(Plan.this, MapsActivity.class));
                break;
            case R.id.imageView15:
                startActivity(new Intent(Plan.this, Plan.class));
                break;
            case R.id.imageView14:
                showAlert();
                break;
            case R.id.imageView13:
                startActivity(new Intent(Plan.this, Tutorial.class));
                break;

        } //Switch

      }


    private void showAlert() {

        final int[] index = {0};

        AlertDialog.Builder builder = new AlertDialog.Builder(Plan.this);
        builder.setCancelable(false);
        builder.setMessage("คุณต้องการค้นหา หมายเลขห้อง หรือ รายละเอียดห้อง");
        builder.setNegativeButton("หมายเลขห้อง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index[0] = 0;
                Intent intent = new Intent(Plan.this, Search.class);
                intent.putExtra("index", index[0]);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("รายละเอียดห้อง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index[0] = 1;
                Intent intent = new Intent(Plan.this, Search.class);
                intent.putExtra("index", index[0]);
                startActivity(intent);
            }
        });
        builder.show();



    }

}






