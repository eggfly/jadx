package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.BitSet;

public class LLkAnalyzer implements LLkGrammarAnalyzer {
    protected Tool DW;
    protected Grammar FH;
    protected boolean Hw;
    private AlternativeBlock Zo;
    public boolean j6;
    CharFormatter v5;

    public Lookahead j6(int i, RuleEndElement ruleEndElement) {
        String FH;
        RuleBlock ruleBlock = (RuleBlock) ruleEndElement.DW;
        if (this.Hw) {
            FH = CodeGenerator.FH(ruleBlock.FH());
        } else {
            FH = ruleBlock.FH();
        }
        if (this.j6) {
            System.out.println(new StringBuffer().append("FOLLOW(").append(i).append(",").append(FH).append(")").toString());
        }
        if (ruleEndElement.j6[i]) {
            if (this.j6) {
                System.out.println(new StringBuffer().append("FOLLOW cycle to ").append(FH).toString());
            }
            return new Lookahead(FH);
        } else if (ruleEndElement.FH[i] != null) {
            if (this.j6) {
                System.out.println(new StringBuffer().append("cache entry FOLLOW(").append(i).append(") for ").append(FH).append(": ").append(ruleEndElement.FH[i].j6(",", this.v5, this.FH)).toString());
            }
            if (ruleEndElement.FH[i].DW == null) {
                return (Lookahead) ruleEndElement.FH[i].clone();
            }
            RuleEndElement ruleEndElement2 = ((RuleSymbol) this.FH.j6(ruleEndElement.FH[i].DW)).j6().J0;
            if (ruleEndElement2.FH[i] == null) {
                return (Lookahead) ruleEndElement.FH[i].clone();
            }
            if (this.j6) {
                System.out.println(new StringBuffer().append("combining FOLLOW(").append(i).append(") for ").append(FH).append(": from ").append(ruleEndElement.FH[i].j6(",", this.v5, this.FH)).append(" with FOLLOW for ").append(((RuleBlock) ruleEndElement2.DW).FH()).append(": ").append(ruleEndElement2.FH[i].j6(",", this.v5, this.FH)).toString());
            }
            if (ruleEndElement2.FH[i].DW == null) {
                ruleEndElement.FH[i].j6(ruleEndElement2.FH[i]);
                ruleEndElement.FH[i].DW = null;
            } else {
                Lookahead j6 = j6(i, ruleEndElement2);
                ruleEndElement.FH[i].j6(j6);
                ruleEndElement.FH[i].DW = j6.DW;
            }
            if (this.j6) {
                System.out.println(new StringBuffer().append("saving FOLLOW(").append(i).append(") for ").append(FH).append(": from ").append(ruleEndElement.FH[i].j6(",", this.v5, this.FH)).toString());
            }
            return (Lookahead) ruleEndElement.FH[i].clone();
        } else {
            ruleEndElement.j6[i] = true;
            Lookahead lookahead = new Lookahead();
            RuleSymbol ruleSymbol = (RuleSymbol) this.FH.j6(FH);
            for (int i2 = 0; i2 < ruleSymbol.DW(); i2++) {
                RuleRefElement j62 = ruleSymbol.j6(i2);
                if (this.j6) {
                    System.out.println(new StringBuffer().append("next[").append(FH).append("] is ").append(j62.Zo.toString()).toString());
                }
                Lookahead j63 = j62.Zo.j6(i);
                if (this.j6) {
                    System.out.println(new StringBuffer().append("FIRST of next[").append(FH).append("] ptr is ").append(j63.toString()).toString());
                }
                if (j63.DW != null && j63.DW.equals(FH)) {
                    j63.DW = null;
                }
                lookahead.j6(j63);
                if (this.j6) {
                    System.out.println(new StringBuffer().append("combined FOLLOW[").append(FH).append("] is ").append(lookahead.toString()).toString());
                }
            }
            ruleEndElement.j6[i] = false;
            if (lookahead.j6.DW() && lookahead.DW == null) {
                if (this.FH instanceof TreeWalkerGrammar) {
                    lookahead.j6.j6(3);
                } else if (this.FH instanceof LexerGrammar) {
                    lookahead.FH();
                } else {
                    lookahead.j6.j6(1);
                }
            }
            if (this.j6) {
                System.out.println(new StringBuffer().append("saving FOLLOW(").append(i).append(") for ").append(FH).append(": ").append(lookahead.j6(",", this.v5, this.FH)).toString());
            }
            ruleEndElement.FH[i] = (Lookahead) lookahead.clone();
            return lookahead;
        }
    }

    public Lookahead j6(int i, ActionElement actionElement) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("lookAction(").append(i).append(",").append(actionElement).append(")").toString());
        }
        return actionElement.Zo.j6(i);
    }

    public Lookahead j6(int i, AlternativeBlock alternativeBlock) {
        int i2 = 0;
        if (this.j6) {
            System.out.println(new StringBuffer().append("lookAltBlk(").append(i).append(",").append(alternativeBlock).append(")").toString());
        }
        AlternativeBlock alternativeBlock2 = this.Zo;
        this.Zo = alternativeBlock;
        Lookahead lookahead = new Lookahead();
        for (int i3 = 0; i3 < alternativeBlock.DW.DW(); i3++) {
            if (this.j6) {
                System.out.println(new StringBuffer().append("alt ").append(i3).append(" of ").append(alternativeBlock).toString());
            }
            this.Zo.Hw = i3;
            Alternative DW = alternativeBlock.DW(i3);
            AlternativeElement alternativeElement = DW.j6;
            if (this.j6 && DW.j6 == DW.DW) {
                System.out.println(new StringBuffer().append("alt ").append(i3).append(" is empty").toString());
            }
            lookahead.j6(alternativeElement.j6(i));
        }
        if (i == 1 && alternativeBlock.v5 && j6(alternativeBlock, this.Hw)) {
            if (this.Hw) {
                BitSet bitSet = (BitSet) ((LexerGrammar) this.FH).gn.clone();
                int[] FH = lookahead.j6.FH();
                while (i2 < FH.length) {
                    bitSet.Zo(FH[i2]);
                    i2++;
                }
                lookahead.j6 = bitSet;
            } else {
                lookahead.j6.j6(4, this.FH.Hw.DW());
            }
        }
        this.Zo = alternativeBlock2;
        return lookahead;
    }

    public Lookahead j6(int i, BlockEndElement blockEndElement) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("lookBlockEnd(").append(i).append(", ").append(blockEndElement.DW).append("); lock is ").append(blockEndElement.j6[i]).toString());
        }
        if (blockEndElement.j6[i]) {
            return new Lookahead();
        }
        Lookahead j6;
        if ((blockEndElement.DW instanceof ZeroOrMoreBlock) || (blockEndElement.DW instanceof OneOrMoreBlock)) {
            blockEndElement.j6[i] = true;
            j6 = j6(i, blockEndElement.DW);
            blockEndElement.j6[i] = false;
        } else {
            j6 = new Lookahead();
        }
        if (blockEndElement.DW instanceof TreeElement) {
            j6.j6(Lookahead.j6(3));
            return j6;
        } else if (blockEndElement.DW instanceof SynPredBlock) {
            j6.FH();
            return j6;
        } else {
            j6.j6(blockEndElement.DW.Zo.j6(i));
            return j6;
        }
    }

    public Lookahead j6(int i, CharLiteralElement charLiteralElement) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("lookCharLiteral(").append(i).append(",").append(charLiteralElement).append(")").toString());
        }
        if (i > 1) {
            return charLiteralElement.Zo.j6(i - 1);
        }
        if (!this.Hw) {
            this.DW.FH("Character literal reference found in parser");
            return Lookahead.j6(charLiteralElement.Hw());
        } else if (!charLiteralElement.Hw) {
            return Lookahead.j6(charLiteralElement.Hw());
        } else {
            BitSet bitSet = (BitSet) ((LexerGrammar) this.FH).gn.clone();
            if (this.j6) {
                System.out.println(new StringBuffer().append("charVocab is ").append(bitSet.toString()).toString());
            }
            j6(bitSet, (AlternativeElement) charLiteralElement);
            if (this.j6) {
                System.out.println(new StringBuffer().append("charVocab after removal of prior alt lookahead ").append(bitSet.toString()).toString());
            }
            bitSet.DW(charLiteralElement.Hw());
            return new Lookahead(bitSet);
        }
    }

    public Lookahead j6(int i, CharRangeElement charRangeElement) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("lookCharRange(").append(i).append(",").append(charRangeElement).append(")").toString());
        }
        if (i > 1) {
            return charRangeElement.Zo.j6(i - 1);
        }
        BitSet v5 = BitSet.v5(charRangeElement.DW);
        for (int i2 = charRangeElement.DW + 1; i2 <= charRangeElement.FH; i2++) {
            v5.j6(i2);
        }
        return new Lookahead(v5);
    }

    public Lookahead j6(int i, GrammarAtom grammarAtom) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("look(").append(i).append(",").append(grammarAtom).append("[").append(grammarAtom.Hw()).append("])").toString());
        }
        if (this.Hw) {
            this.DW.FH("token reference found in lexer");
        }
        if (i > 1) {
            return grammarAtom.Zo.j6(i - 1);
        }
        Lookahead j6 = Lookahead.j6(grammarAtom.Hw());
        if (!grammarAtom.Hw) {
            return j6;
        }
        j6.j6.j6(4, this.FH.Hw.DW());
        j6(j6.j6, (AlternativeElement) grammarAtom);
        return j6;
    }

    public Lookahead j6(int i, OneOrMoreBlock oneOrMoreBlock) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("look+").append(i).append(",").append(oneOrMoreBlock).append(")").toString());
        }
        return j6(i, (AlternativeBlock) oneOrMoreBlock);
    }

    public Lookahead j6(int i, RuleBlock ruleBlock) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("lookRuleBlk(").append(i).append(",").append(ruleBlock).append(")").toString());
        }
        return j6(i, (AlternativeBlock) ruleBlock);
    }

    public Lookahead DW(int i, RuleEndElement ruleEndElement) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("lookRuleBlockEnd(").append(i).append("); noFOLLOW=").append(ruleEndElement.Hw).append("; lock is ").append(ruleEndElement.j6[i]).toString());
        }
        if (!ruleEndElement.Hw) {
            return j6(i, ruleEndElement);
        }
        Lookahead lookahead = new Lookahead();
        lookahead.FH();
        lookahead.FH = BitSet.v5(i);
        return lookahead;
    }

    public Lookahead j6(int i, RuleRefElement ruleRefElement) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("lookRuleRef(").append(i).append(",").append(ruleRefElement).append(")").toString());
        }
        RuleSymbol ruleSymbol = (RuleSymbol) this.FH.j6(ruleRefElement.j6);
        if (ruleSymbol == null || !ruleSymbol.FH) {
            this.DW.j6(new StringBuffer().append("no definition of rule ").append(ruleRefElement.j6).toString(), this.FH.j6(), ruleRefElement.Zo(), ruleRefElement.VH());
            return new Lookahead();
        }
        RuleEndElement ruleEndElement = ruleSymbol.j6().J0;
        boolean z = ruleEndElement.Hw;
        ruleEndElement.Hw = true;
        Lookahead j6 = j6(i, ruleRefElement.j6);
        if (this.j6) {
            System.out.println(new StringBuffer().append("back from rule ref to ").append(ruleRefElement.j6).toString());
        }
        ruleEndElement.Hw = z;
        if (j6.DW != null) {
            this.DW.j6(new StringBuffer().append("infinite recursion to rule ").append(j6.DW).append(" from rule ").append(ruleRefElement.gn).toString(), this.FH.j6(), ruleRefElement.Zo(), ruleRefElement.VH());
        }
        if (j6.j6()) {
            if (this.j6) {
                System.out.println(new StringBuffer().append("rule ref to ").append(ruleRefElement.j6).append(" has eps, depth: ").append(j6.FH).toString());
            }
            j6.DW();
            int[] FH = j6.FH.FH();
            j6.FH = null;
            for (int i2 : FH) {
                j6.j6(ruleRefElement.Zo.j6(i - (i - i2)));
            }
        }
        return j6;
    }

    public Lookahead j6(int i, StringLiteralElement stringLiteralElement) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("lookStringLiteral(").append(i).append(",").append(stringLiteralElement).append(")").toString());
        }
        if (this.Hw) {
            if (i > stringLiteralElement.we.length()) {
                return stringLiteralElement.Zo.j6(i - stringLiteralElement.we.length());
            }
            return Lookahead.j6(stringLiteralElement.we.charAt(i - 1));
        } else if (i > 1) {
            return stringLiteralElement.Zo.j6(i - 1);
        } else {
            Lookahead j6 = Lookahead.j6(stringLiteralElement.Hw());
            if (!stringLiteralElement.Hw) {
                return j6;
            }
            j6.j6.j6(4, this.FH.Hw.DW());
            return j6;
        }
    }

    public Lookahead j6(int i, SynPredBlock synPredBlock) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("look=>(").append(i).append(",").append(synPredBlock).append(")").toString());
        }
        return synPredBlock.Zo.j6(i);
    }

    public Lookahead j6(int i, TokenRangeElement tokenRangeElement) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("lookTokenRange(").append(i).append(",").append(tokenRangeElement).append(")").toString());
        }
        if (i > 1) {
            return tokenRangeElement.Zo.j6(i - 1);
        }
        BitSet v5 = BitSet.v5(tokenRangeElement.DW);
        for (int i2 = tokenRangeElement.DW + 1; i2 <= tokenRangeElement.FH; i2++) {
            v5.j6(i2);
        }
        return new Lookahead(v5);
    }

    public Lookahead j6(int i, TreeElement treeElement) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("look(").append(i).append(",").append(treeElement.we).append("[").append(treeElement.we.Hw()).append("])").toString());
        }
        if (i > 1) {
            return treeElement.Zo.j6(i - 1);
        }
        if (treeElement.we instanceof WildcardElement) {
            return treeElement.we.j6(1);
        }
        Lookahead j6 = Lookahead.j6(treeElement.we.Hw());
        if (!treeElement.we.Hw) {
            return j6;
        }
        j6.j6.j6(4, this.FH.Hw.DW());
        return j6;
    }

    public Lookahead j6(int i, WildcardElement wildcardElement) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("look(").append(i).append(",").append(wildcardElement).append(")").toString());
        }
        if (i > 1) {
            return wildcardElement.Zo.j6(i - 1);
        }
        BitSet bitSet;
        if (this.Hw) {
            bitSet = (BitSet) ((LexerGrammar) this.FH).gn.clone();
        } else {
            bitSet = new BitSet(1);
            bitSet.j6(4, this.FH.Hw.DW());
            if (this.j6) {
                System.out.println(new StringBuffer().append("look(").append(i).append(",").append(wildcardElement).append(") after not: ").append(bitSet).toString());
            }
        }
        return new Lookahead(bitSet);
    }

    public Lookahead j6(int i, ZeroOrMoreBlock zeroOrMoreBlock) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("look*(").append(i).append(",").append(zeroOrMoreBlock).append(")").toString());
        }
        Lookahead j6 = j6(i, (AlternativeBlock) zeroOrMoreBlock);
        j6.j6(zeroOrMoreBlock.Zo.j6(i));
        return j6;
    }

    public Lookahead j6(int i, String str) {
        if (this.j6) {
            System.out.println(new StringBuffer().append("lookRuleName(").append(i).append(",").append(str).append(")").toString());
        }
        RuleBlock j6 = ((RuleSymbol) this.FH.j6(str)).j6();
        if (j6.Ws[i]) {
            if (this.j6) {
                System.out.println(new StringBuffer().append("infinite recursion to rule ").append(j6.FH()).toString());
            }
            return new Lookahead(str);
        } else if (j6.QX[i] != null) {
            if (this.j6) {
                System.out.println(new StringBuffer().append("found depth ").append(i).append(" result in FIRST ").append(str).append(" cache: ").append(j6.QX[i].j6(",", this.v5, this.FH)).toString());
            }
            return (Lookahead) j6.QX[i].clone();
        } else {
            j6.Ws[i] = true;
            Lookahead j62 = j6(i, j6);
            j6.Ws[i] = false;
            j6.QX[i] = (Lookahead) j62.clone();
            if (this.j6) {
                System.out.println(new StringBuffer().append("saving depth ").append(i).append(" result in FIRST ").append(str).append(" cache: ").append(j6.QX[i].j6(",", this.v5, this.FH)).toString());
            }
            return j62;
        }
    }

    private void j6(BitSet bitSet, AlternativeElement alternativeElement) {
        AlternativeElement alternativeElement2 = this.Zo.DW(this.Zo.Hw).j6;
        if (alternativeElement2 instanceof TreeElement) {
            if (((TreeElement) alternativeElement2).we != alternativeElement) {
                return;
            }
        } else if (alternativeElement != alternativeElement2) {
            return;
        }
        for (int i = 0; i < this.Zo.Hw; i++) {
            bitSet.DW(this.Zo.DW(i).j6.j6(1).j6);
        }
    }

    public boolean j6(AlternativeBlock alternativeBlock, boolean z) {
        if ((alternativeBlock instanceof ZeroOrMoreBlock) || (alternativeBlock instanceof OneOrMoreBlock) || (alternativeBlock instanceof SynPredBlock) || alternativeBlock.DW.DW() == 0) {
            return false;
        }
        for (int i = 0; i < alternativeBlock.DW.DW(); i++) {
            Alternative DW = alternativeBlock.DW(i);
            if (DW.FH != null || DW.Hw != null || DW.v5 != null) {
                return false;
            }
            AlternativeElement alternativeElement = DW.j6;
            if ((!(alternativeElement instanceof CharLiteralElement) && !(alternativeElement instanceof TokenRefElement) && !(alternativeElement instanceof CharRangeElement) && !(alternativeElement instanceof TokenRangeElement) && (!(alternativeElement instanceof StringLiteralElement) || z)) || !(alternativeElement.Zo instanceof BlockEndElement) || alternativeElement.DW() != 1) {
                return false;
            }
        }
        return true;
    }
}
