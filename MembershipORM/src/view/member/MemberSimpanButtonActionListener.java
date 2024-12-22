package view.member;

import dao.MemberDao;
import model.JenisMember;
import model.Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class MemberSimpanButtonActionListener implements ActionListener {
    private MemberFrame memberFrame;
    private MemberDao memberDao;

    public MemberSimpanButtonActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = this.memberFrame.getNama();
        if(nama.isEmpty()){
            this.memberFrame.showAlert("Nama tidak boleh kosong");
        }else{
            JenisMember jenisMember = this.memberFrame.getJenisMember();
            Member member = new Member();
            member.setId(UUID.randomUUID().toString());
            member.setNama(nama);
            member.setJenisMember(jenisMember);
            member.setJenisMemberId(jenisMember.getId());
            this.memberFrame.addMember(member);
            this.memberDao.insert(member);
        }
    }
}
