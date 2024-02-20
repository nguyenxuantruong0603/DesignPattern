package com.example.hocdesignpattern.observer.notifiers;

import android.util.Log;

import com.example.hocdesignpattern.observer.Wage;
import com.example.hocdesignpattern.observer.Observer;
import com.example.hocdesignpattern.observer.SubjectObserver;

public class TikTok extends Observer {
    public TikTok(SubjectObserver subjectObserver) {
        this.subjectObserver = subjectObserver;
        this.subjectObserver.addEmployee(this);
    }

    @Override
    public void payWage() {
        if (subjectObserver instanceof Wage) {
            Wage wage = (Wage) subjectObserver;
            Log.e("Lương TikTok", "Lương cơ bản: " + wage.getDefaultWage() + " | Thưởng thêm: " + wage.getThuongThem());
        }
    }

    @Override
    public void notifyWageChange(Integer wage) {
        Log.e("Lương Mới TikTok", String.valueOf(wage));
    }
}
