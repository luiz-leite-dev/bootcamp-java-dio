package collections;

import java.util.Objects;

public class User {

    private int code;

    private String name;

    public User(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User user){
            return (this == user) || (this.code == user.code && Objects.equals(this.name, user.name));
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "{ 'code' : "+code+", 'name' : '"+name+"' }";
    }

    

}
