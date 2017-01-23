import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class aik extends aiu<aik, ail> {
    private aob v5;

    public /* synthetic */ Object call() {
        return j6();
    }

    protected aik(aoh aoh) {
        super(aoh);
        this.v5 = anp.j6;
    }

    public aik j6(aob aob) {
        this.v5 = aob;
        return this;
    }

    public ail j6() {
        aoc aoc = null;
        Zo();
        this.v5.j6(JGitText.j6().pullTaskName, 2);
        try {
            String we = this.j6.we();
            if (we == null) {
                throw new ajj(JGitText.j6().pullOnRepoWithoutHEADCurrentlyNotSupported);
            } else if (we.startsWith("refs/heads/")) {
                String substring = we.substring("refs/heads/".length());
                if (this.j6.aM().equals(aok.SAFE)) {
                    ani VH = this.j6.VH();
                    we = VH.j6("branch", substring, "remote");
                    if (we == null) {
                        we = "origin";
                    }
                    String j6 = VH.j6("branch", substring, "merge");
                    boolean j62 = VH.j6("branch", substring, "rebase", false);
                    if (j6 == null) {
                        we = "branch." + substring + "." + "merge";
                        throw new ajc(MessageFormat.format(JGitText.j6().missingConfigurationForKey, new Object[]{we}));
                    }
                    String j63;
                    att j64;
                    boolean z = !we.equals(".");
                    if (z) {
                        j63 = VH.j6("remote", we, "url");
                        if (j63 == null) {
                            we = "remote." + we + "." + "url";
                            throw new ajc(MessageFormat.format(JGitText.j6().missingConfigurationForKey, new Object[]{we}));
                        } else if (this.v5.j6()) {
                            throw new aiw(MessageFormat.format(JGitText.j6().operationCanceled, new Object[]{JGitText.j6().pullTaskName}));
                        } else {
                            aiu aic = new aic(this.j6);
                            aic.j6(we);
                            aic.j6(this.v5);
                            j6(aic);
                            j64 = aic.j6();
                        }
                    } else {
                        j63 = "local repository";
                        j64 = null;
                    }
                    this.v5.j6(1);
                    if (this.v5.j6()) {
                        throw new aiw(MessageFormat.format(JGitText.j6().operationCanceled, new Object[]{JGitText.j6().pullTaskName}));
                    }
                    anb v5;
                    ail ail;
                    if (z) {
                        if (j64 != null) {
                            aoc = j64.j6(j6);
                            if (aoc == null) {
                                aoc = j64.j6("refs/heads/" + j6);
                            }
                        }
                        if (aoc == null) {
                            throw new ajg(MessageFormat.format(JGitText.j6().couldNotGetAdvertisedRef, new Object[]{j6}));
                        }
                        v5 = aoc.v5();
                    } else {
                        try {
                            v5 = this.j6.DW(j6);
                            if (v5 == null) {
                                throw new ajn(MessageFormat.format(JGitText.j6().refNotResolved, new Object[]{j6}));
                            }
                        } catch (Throwable e) {
                            throw new ajg(JGitText.j6().exceptionCaughtDuringExecutionOfPullCommand, e);
                        }
                    }
                    if (j62) {
                        try {
                            ail = new ail(j64, we, new ain(this.j6).j6(v5).j6(this.v5).j6(ain$b.BEGIN).j6());
                        } catch (Throwable e2) {
                            throw new ajg(e2.getMessage(), e2);
                        } catch (Throwable e22) {
                            throw new ajg(e22.getMessage(), e22);
                        } catch (Throwable e222) {
                            throw new ajg(e222.getMessage(), e222);
                        } catch (Throwable e2222) {
                            throw new ajg(e2222.getMessage(), e2222);
                        }
                    }
                    aii aii = new aii(this.j6);
                    aii.j6("branch '" + aoh.v5(j6) + "' of " + j63, v5);
                    try {
                        aij j65 = aii.j6();
                        this.v5.j6(1);
                        ail = new ail(j64, we, j65);
                    } catch (Throwable e22222) {
                        throw new ajg(e22222.getMessage(), e22222);
                    } catch (Throwable e222222) {
                        throw new ajg(e222222.getMessage(), e222222);
                    } catch (Throwable e2222222) {
                        throw new ajg(e2222222.getMessage(), e2222222);
                    } catch (Throwable e22222222) {
                        throw new ajg(e22222222.getMessage(), e22222222);
                    } catch (Throwable e222222222) {
                        throw new ajg(e222222222.getMessage(), e222222222);
                    } catch (Throwable e2222222222) {
                        throw new ajg(e2222222222.getMessage(), e2222222222);
                    }
                    this.v5.DW();
                    return ail;
                }
                throw new ajp(MessageFormat.format(JGitText.j6().cannotPullOnARepoWithState, new Object[]{this.j6.aM().name()}));
            } else {
                throw new aja();
            }
        } catch (Throwable e22222222222) {
            throw new ajg(JGitText.j6().exceptionCaughtDuringExecutionOfPullCommand, e22222222222);
        }
    }
}
