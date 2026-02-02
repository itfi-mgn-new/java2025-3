package lesson16;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


// --add-opens=java.base/jdk.internal.org.objectweb.asm=ALL-UNNAMED 
// --add-opens=java.base/jdk.internal.org.objectweb.asm.util=ALL-UNNAMED 
public class JavaScriptTest {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        
        if (engine == null) {
            System.err.println("JavaScript engine not found");
            return;
        }
        
        String script = "var message = 'Hello world'; message;";
        try {
            Object result = engine.eval(script);
            System.err.println("Result=" + result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        
        engine.put("x", 10);
        engine.put("y", 20);
        try {
            Object sum = engine.eval("x + y");
            System.err.println("Total: " + sum);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
