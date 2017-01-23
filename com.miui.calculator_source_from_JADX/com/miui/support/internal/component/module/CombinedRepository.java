package com.miui.support.internal.component.module;

import com.miui.support.module.Repository;
import java.io.File;

public class CombinedRepository extends Repository {
    private Repository[] f2299a;

    public CombinedRepository(Repository... repositoryArr) {
        this.f2299a = repositoryArr;
    }

    public boolean m3883a(String str) {
        for (Repository a : this.f2299a) {
            if (a.m3876a(str)) {
                return true;
            }
        }
        return false;
    }

    public String m3882a(File file, String str) {
        for (Repository repository : this.f2299a) {
            if (repository.m3876a(str)) {
                return repository.m3873a(file, str);
            }
        }
        return null;
    }
}
