package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
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

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Plan extends AppCompatActivity implements View.OnClickListener {

    private ImageView bar1ImageView, bar2ImageView, bar3ImageView, bar4ImageView, bar5ImageView;

    ListView listView;


    @Override
    protected void attachBaseContext(Context base){
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        final String title[]={"อาคารที่ 1"
                ,"อาคารที่ 2"
                ,"อาคารที่ 3"
                ,"อาคารที่ 4"
                ,"อาคารที่ 5"
                ,"อาคารที่ 6"
                ,"อาคารที่ 7"
                ,"อาคารที่ 8"
                ,"อาคารที่ 9"
                ,"อาคารที่ 10"
                ,"อาคารที่ 11"
                ,"อาคารที่ 12"
                ,"อาคารที่ 13"
                ,"อาคารที่ 14"
                ,"อาคารที่ 15"
                ,"อาคารที่ 16"
                ,"อาคารที่ 17"

        };

        final String name[] = {"อาคารอำนวยการ"
                ,"อาคารสำนักงานบริการ"
                ,"อาคารอเนกประสงค์"
                ,"อาคารฝึกพื้นฐานทาง วิศวกรรม"
                ,"อาคารวิศวอุตสาหการ"
                ,"อาคารช่างยนต์ ๑"
                ,"อาคารแผนกอัญมณี"
                ,"อาคารช่างกลโรงงาน"
                ,"อาคารอนุสรณ์ 40 ปี"
                ,"อาคารช่างยนต์ ๒"
                ,"อาคารสาขาวิศวกรรมโยธา"
                ,"อาคารวิศวกรรมการผลิตเครื่องมือและแม่พิมพ์"
                ,"อาคารเรียนและปฏิบัติการสาขาเครื่องจักรอัตโนมัติ"
                ,"อาคารช่างหล่อ"
                ,"อาคารกิจกรรมนักศึกษา"
                ,"อาคารวิศวกรรมไฟฟ้า"
                ,"อาคารอิเล็กทรอนิกส์"};

        final Integer[] imageId = {
                R.drawable.b01,//1
                R.drawable.b03,//2
                R.drawable.b02,//3
                R.drawable.b15,//4
                R.drawable.b20,//5
                R.drawable.b05,//6
                R.drawable.b06,//7
                R.drawable.b07,//8
                R.drawable.b09,//9
                R.drawable.b11,//10
                R.drawable.b20,//11 ยังไม่ได้ถ่ายรูป
                R.drawable.b14,//12
                R.drawable.b16,//13 ยังไม่ได้ถ่ายรูป
                R.drawable.b16,//14
                R.drawable.b19,//15
                R.drawable.b12,//16
                R.drawable.b13,//17
        };

        final String detail[] = {"   ตั้งอยู่ด้านหน้าของมหาวิทยาลัยเทคโนโลยีราชมงคลพระนคร ศูนย์พระนครเหนือ และมีพระวิษณุประดิษฐานอยู่ด้านหน้าของอาคารอำนวยการ"
                ,""
                ,"   เป็นอาคารเรียนของสาขาวิชาวิศวกรรมแมคคาทรอนิกส์  และประกอบไปด้วยห้องสมุด ห้อง Self-Access ห้องประชุมเฟืองทอง และโรงยิม"
                ,"   เป็นการเรียนฝึกพื้นฐาน เช่น วิชาตะไบ "
                ,"   เป็นอาคารเรียนของสาขาวิชาวิศวกรรมอุตสาหการ"
                ,"   เป็นอาคารเรียนระดับปริญญาตรี สาขาวิชาวิศวกรรมเครื่องกล"
                ,"   เป็นอาคารเรียนของสาขาวิชาเทคโนโลยีแม่พิมพ์และเครื่องประดับ"
                ,"   เป็นอาคารเรียนระดับ ปวช. ช่างกลโรงงาน"
                ,"   เป็นอาคารของคณะวิทยาศาสตร์และเทคโนโลยี โดยภายในอาคารแบ่งการเรียนการสอนออกเป็น 3 สาขาวิชา คือ 1.สาขาวิชาวิทยาการคอมพิวเตอร์ 2.สาขาวิชาสิ่งแวดล้อมและทรัพยากรธรรมชาติ 3.สาขาวิชาวัสดุศาสตร์อุตสาหกรรม และมีการเรียนการสอนของสาขาวิชาวิศวกรรมคอมพิวเตอร์"
                ,"   เป็นอาคารเรียนของสาขาวิชาวิศวกรรมเครื่องกล แผนกวิชาช่างยนต์ และระดับ ปวช. ช่างยนต์"
                ,"   เป็นอาคารเรียนของสาขาวิชาวิศวกรรมโยธา"
                ,"   เป็นอาคารเรียนระดับ ปริญญาตรีของสาขาวิชาวิศวกรรมการผลิตเครื่องมือและแม่พิมพ์"
                ,""
                ,"   เป็นอาคารสำหรับการเรียนการสอน วิชาวิศวกรรมงานหล่อ"
                ,"   เป็นอาคารที่ประกอบด้วยห้องพักครู คณะศิลปะศาสตร์ ห้องชมรมต่างๆ ห้องแนะแนว ห้องฟิตเนต และโรงอาหาร"
                ,"   เป็นอาคารเรียนระดับปริญญาตรี สาขาวิชาวิศวกรรมไฟฟ้า และ ระดับ ปวช.  ช่างไฟฟ้ากำลัง"
                ,"   เป็นอาคารเรียนระดับปริญญาตรี สาขาวิชาวิศวกรรมอิเล็กทรอนิกส์และโทรคมนาคม และระดับ ปวช. ช่างอิเล็กทรอนิกส์"
        };




        CustomList adapter = new CustomList(Plan.this,name,title,imageId);
        listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Dialog dialog = new Dialog(Plan.this);
                dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_data);
                TextView textView13 = (TextView)dialog.findViewById(R.id.textView13);
                textView13.setText(title[i]);
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
        builder.setMessage("กรุณาเลือกรายละเอียดข้อมูลที่ท่านต้องการค้นหา");
        builder.setNegativeButton("หมายเลขห้อง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index[0] = 0;
                Intent intent = new Intent(Plan.this, Search.class);
                intent.putExtra("index", index[0]);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("ชื่อห้อง", new DialogInterface.OnClickListener() {
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






