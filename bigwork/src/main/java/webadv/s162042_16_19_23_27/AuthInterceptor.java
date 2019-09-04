package webadv.s162042_16_19_23_27;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//鎷︽埅鍣�
@Component
public class AuthInterceptor implements HandlerInterceptor{
	
	
	 /**
	聽 聽 聽* preHandle鏂规硶鏄繘琛屽鐞嗗櫒鎷︽埅鐢ㄧ殑锛岄【鍚嶆�濅箟锛岃鏂规硶灏嗗湪Controller澶勭悊涔嬪墠杩涜璋冪敤锛孲pringMVC涓殑Interceptor鎷︽埅鍣ㄦ槸閾惧紡鐨勶紝鍙互鍚屾椂瀛樺湪
	聽 聽 聽* 澶氫釜Interceptor锛岀劧鍚嶴pringMVC浼氭牴鎹０鏄庣殑鍓嶅悗椤哄簭涓�涓帴涓�涓殑鎵ц锛岃�屼笖鎵�鏈夌殑Interceptor涓殑preHandle鏂规硶閮戒細鍦�
	聽 聽 聽* Controller鏂规硶璋冪敤涔嬪墠璋冪敤銆係pringMVC鐨勮繖绉岻nterceptor閾惧紡缁撴瀯涔熸槸鍙互杩涜涓柇鐨勶紝杩欑涓柇鏂瑰紡鏄护preHandle鐨勮繑
	聽 聽 聽* 鍥炲�间负false锛屽綋preHandle鐨勮繑鍥炲�间负false鐨勬椂鍊欐暣涓姹傚氨缁撴潫浜嗐��
	聽 聽 聽*/
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String start = System.currentTimeMillis()+"";
		
		System.out.println(start);
		
		if( request.getSession().getAttribute("s_id")==null&&
				request.getSession().getAttribute("t_user")==null&&
				request.getSession().getAttribute("admin_id")==null) 
		{
			response.sendRedirect("/404");
			return false;
		}else
			return true;
	}
	
	
	/**
	聽 聽 聽* 杩欎釜鏂规硶鍙細鍦ㄥ綋鍓嶈繖涓狪nterceptor鐨刾reHandle鏂规硶杩斿洖鍊间负true鐨勬椂鍊欐墠浼氭墽琛屻�俻ostHandle鏄繘琛屽鐞嗗櫒鎷︽埅鐢ㄧ殑锛屽畠鐨勬墽琛屾椂闂存槸鍦ㄥ鐞嗗櫒杩涜澶勭悊涔�
	聽 聽 聽* 鍚庯紝涔熷氨鏄湪Controller鐨勬柟娉曡皟鐢ㄤ箣鍚庢墽琛岋紝浣嗘槸瀹冧細鍦―ispatcherServlet杩涜瑙嗗浘鐨勬覆鏌撲箣鍓嶆墽琛岋紝涔熷氨鏄鍦ㄨ繖涓柟娉曚腑浣犲彲浠ュModelAndView杩涜鎿�
	聽 聽 聽* 浣溿�傝繖涓柟娉曠殑閾惧紡缁撴瀯璺熸甯歌闂殑鏂瑰悜鏄浉鍙嶇殑锛屼篃灏辨槸璇村厛澹版槑鐨処nterceptor鎷︽埅鍣ㄨ鏂规硶鍙嶈�屼細鍚庤皟鐢紝杩欒窡Struts2閲岄潰鐨勬嫤鎴櫒鐨勬墽琛岃繃绋嬫湁鐐瑰儚锛�
	聽 聽 聽* 鍙槸Struts2閲岄潰鐨刬ntercept鏂规硶涓鎵嬪姩鐨勮皟鐢ˋctionInvocation鐨刬nvoke鏂规硶锛孲truts2涓皟鐢ˋctionInvocation鐨刬nvoke鏂规硶灏辨槸璋冪敤涓嬩竴涓狪nterceptor
	聽 聽 聽* 鎴栬�呮槸璋冪敤action锛岀劧鍚庤鍦↖nterceptor涔嬪墠璋冪敤鐨勫唴瀹归兘鍐欏湪璋冪敤invoke涔嬪墠锛岃鍦↖nterceptor涔嬪悗璋冪敤鐨勫唴瀹归兘鍐欏湪璋冪敤invoke鏂规硶涔嬪悗銆�
	聽 聽 聽*/
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView
			) throws Exception {
		System.out.println("postHandle  ");
		if(response.getStatus()==500){
			modelAndView.setViewName("500.html");
			//
			 //setViewName(String viewName);
			 // 涓烘ModelAndView璁剧疆瑙嗗浘鍚嶇О锛岀敱DispatcherServlet閫氳繃ViewResolver瑙ｆ瀽銆� 灏嗚鐩栦换浣曢鍏堝瓨鍦ㄧ殑瑙嗗浘鍚嶇О鎴栬鍥俱��
			 
		}else if(response.getStatus()==404){
			modelAndView.setViewName("404.html");
		}
	}

	
	
/**
聽 聽 聽* 璇ユ柟娉曚篃鏄渶瑕佸綋鍓嶅搴旂殑Interceptor鐨刾reHandle鏂规硶鐨勮繑鍥炲�间负true鏃舵墠浼氭墽琛屻�傝鏂规硶灏嗗湪鏁翠釜璇锋眰瀹屾垚涔嬪悗锛屼篃灏辨槸DispatcherServlet娓叉煋浜嗚鍥炬墽琛岋紝
聽 聽 聽* 杩欎釜鏂规硶鐨勪富瑕佷綔鐢ㄦ槸鐢ㄤ簬娓呯悊璧勬簮鐨勶紝褰撶劧杩欎釜鏂规硶涔熷彧鑳藉湪褰撳墠杩欎釜Interceptor鐨刾reHandle鏂规硶鐨勮繑鍥炲�间负true鏃舵墠浼氭墽琛屻��
聽 聽 聽*/
/*
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("銆�-MyInterceptor1,鍦ㄦ暣涓姹傜粨鏉熶箣鍚庤璋冪敤,涔熷氨鏄湪DispatcherServlet娓叉煋浜嗗搴旂殑瑙嗗浘涔嬪悗鎵ц(涓昏鐢ㄤ簬璧勬簮娓呯悊宸ヤ綔)-銆�");
	}
*/

}
