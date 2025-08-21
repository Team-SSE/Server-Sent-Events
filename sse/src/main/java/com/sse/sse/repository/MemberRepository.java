package com.sse.sse.repository;

import com.sse.sse.aggregate.Member;
import com.sse.sse.config.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {
    private final ArrayList<Member> memberList = new ArrayList<>();
    private final File file
            = new File("src/main/java/com/sse/sse/db/member.dat");


    public MemberRepository() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loadMembers();
    }

    private void loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
            while (true) {
                memberList.add((Member) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("회원 정보 읽어오기 완료!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Member> findAllMembers() {
        return memberList;
    }

    public Long getLastMemberId() {
        long result = 0;
        if (!memberList.isEmpty())
            result =  memberList.get(memberList.size() - 1).getId();

        return result;
    }

    public int signup(Member newMember) {
        ObjectOutputStream oos = null;
        int result = 0;

        try {
            if(memberList.isEmpty()) {
                oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            } else {
                oos = new MyObjectOutput(new BufferedOutputStream(new FileOutputStream(file, true)));
            }


            oos.writeObject(newMember);
            oos.flush();

            memberList.clear();
            loadMembers();
            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

}
