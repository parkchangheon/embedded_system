package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetWorkClient  {

    private String url;

    public NetWorkClient(){
        System.out.println("생성자 호출, url = "+ url);
        connect();
        call("초기화 연결 메세지");

    }
    public void setUrl(String url){
        this.url = url;
    }

    //서비스 시작 호출
    public void connect(){
        System.out.println("connect= "+ url);

    }

    public void call(String message){
        System.out.println("call : " + url + "message = "+ message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close" + url);


    }
    // 의존 관계 주입 끝나면 호출 - 초기화
    //postconstructor랑 preDestory를 권장함
    @PostConstruct
    public void init() throws Exception{
        System.out.println("NetWorkClient.init");
        connect();
        call("초기화 연결 메세지");
        
    }
    //모든것이 끝나면 실행 호출
    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetWorkClient.close");
        disconnect();
    }
}
