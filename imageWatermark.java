package imagecenter;

import java.util.Map;
import org.testng.annotations.Test;
import vacation.TestScript.api.APIBase2;
import vacation.TestScript.base.VacationAPITests;
import vacation.TestScript.utils.VacationAssert;

/*****
 * 
 * 
 * @author micdsk
 *
 */
//类名与Excel名相同
public class imageWatermark extends VacationAPITests {
	@Test(description = "imageWatermark", dataProvider = "common")
	
	//方法名与Excel 中 sheet名相同
	public void imageWatermarkTestcase(Map<String, String> datadriven)
			throws Exception {
		
		//图片中心项目所有接口均需要headers，kv形式
		//传入header
		String key = "accessKey";
		String value = "1098";
		
		//post 参数 imageWatermark入参txt名称、url名称
		String ResponseDetail = APIBase2.post("imageWatermark", key , value , datadriven);
		
		//取出响应结果里面的需要校验的值
		String code = APIBase2.getJsonByName("code", ResponseDetail);
		
		//打印实际结果（响应结果中需要校验的值）
		System.out.println("************实际结果*************，code="+ code);
		
		//打印预期结果（Excel中的值）
		System.out.println("============预期结果=============，code="+ datadriven.get("code"));
		
		//校验实际结果与预期结果
		VacationAssert.verifyTrue(code.equals(datadriven.get("code")),"");
	}
}
