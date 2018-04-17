# mapsmarkerlib-demo

To start using this lib, add below depedency in your project :

             implementation 'id.co.isocorp:mapsmarkerlib:1.0.0'

add repository setting as below :
            
            repositories {
                jcenter()
                maven {
                    url  "https://isocorp.bintray.com/maven"
                }
            }

Put your meta data setting in app's manifest :

            <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="@string/google_maps_key"/>
            
Gather your own key through google https://bit.ly/2asqQ1r, then you can assign the key to your 
google_maps_key



To init the lib, import the library:

            
            import id.co.isocorp.mapsmarkerlib.MapsMarkerLib;
          
then pass current context and activity to the library:


               private MapsMarkerLib pickAddress;
               private TextView tV;
               @Override
               protected void onCreate(Bundle savedInstanceState) {
                   super.onCreate(savedInstanceState);
                   setContentView(R.layout.activity_main);
                   pickAddress = new MapsMarkerLib(this,this);
                   tV = (TextView)findViewById(R.id.my_chosen_address);
               }
               
To gather the result, onActivityResult is the only way, once the chossing location activity is done, 
the value will be sent back through it :
 
                @Override
                    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                        super.onActivityResult(requestCode, resultCode, data);
                        if (resultCode != RESULT_CANCELED){
                            if(requestCode==pickAddress.MARKER_LIB){
                                tV.setText("Chosen Location : " + data.getStringExtra(pickAddress.ADDRESS_NAME));
                            }else{
                                return;
                            }
                        }else {
                            return;
                        }
                
                    }

Our next plan is implementing fused gps in this library, see you another time. 