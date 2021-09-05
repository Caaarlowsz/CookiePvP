package twitter4j;

public interface ConnectionLifeCycleListener
{
    void onConnect();
    
    void onDisconnect();
    
    void onCleanUp();
}
