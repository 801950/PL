/* adacTokenManager.java */
/* Generated By:JavaCC: Do not edit this line. adacTokenManager.java */
package traductor;
import java.util.*;
import java.lang.Exception.*;

/** Token Manager. */
@SuppressWarnings ("unused")
public class adacTokenManager implements adacConstants {
        //lo declarado aquí estará en "ejemploTokenManager"
        //también estará, por ejemplo, "lengthOfMatch", "image", ...
        static int nPalInt = 0;
        static int valNums = 0;
        static void infoToken(String mensaje, Token token){
                System.out.println("(" + token.beginLine + "," + token.beginColumn + "): " + mensaje + " " + token.image);
        }

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x10000000000000L) != 0L)
            return 0;
         if ((active0 & 0xc607effffe0000L) != 0L)
         {
            jjmatchedKind = 58;
            return 24;
         }
         if ((active0 & 0x400L) != 0L)
            return 25;
         if ((active0 & 0x800L) != 0L)
            return 13;
         return -1;
      case 1:
         if ((active0 & 0xc605e7bf7e0000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 1;
            return 24;
         }
         if ((active0 & 0x20840800000L) != 0L)
            return 24;
         return -1;
      case 2:
         if ((active0 & 0xc005e203000000L) != 0L)
            return 24;
         if ((active0 & 0x60005bc7e0000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 58;
               jjmatchedPos = 2;
            }
            return 24;
         }
         return -1;
      case 3:
         if ((active0 & 0x400043c7e0000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 3;
            return 24;
         }
         if ((active0 & 0x2000180000000L) != 0L)
            return 24;
         if ((active0 & 0x2000000000L) != 0L)
            return 17;
         return -1;
      case 4:
         if ((active0 & 0x1c7c0000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 4;
            return 24;
         }
         if ((active0 & 0x20000000L) != 0L)
         {
            if (jjmatchedPos < 3)
            {
               jjmatchedKind = 58;
               jjmatchedPos = 3;
            }
            return 17;
         }
         if ((active0 & 0x4000400020000L) != 0L)
            return 24;
         if ((active0 & 0x2000000000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 4;
            return 26;
         }
         return -1;
      case 5:
         if ((active0 & 0x2000000000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 5;
            return 27;
         }
         if ((active0 & 0x20000000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 5;
            return 26;
         }
         if ((active0 & 0x4000000L) != 0L)
            return 24;
         if ((active0 & 0x187c0000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 5;
            return 24;
         }
         return -1;
      case 6:
         if ((active0 & 0x2020000000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 6;
            return 27;
         }
         if ((active0 & 0x18680000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 6;
            return 24;
         }
         if ((active0 & 0x140000L) != 0L)
            return 24;
         return -1;
      case 7:
         if ((active0 & 0x480000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 7;
            return 24;
         }
         if ((active0 & 0x20000000L) != 0L)
         {
            jjmatchedKind = 58;
            jjmatchedPos = 7;
            return 27;
         }
         if ((active0 & 0x18200000L) != 0L)
            return 24;
         if ((active0 & 0x2000000000L) != 0L)
            return 27;
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 34:
         return jjStartNfaWithStates_0(0, 10, 25);
      case 39:
         return jjStartNfaWithStates_0(0, 11, 13);
      case 40:
         return jjStopAtPos(0, 8);
      case 41:
         return jjStopAtPos(0, 9);
      case 42:
         return jjStopAtPos(0, 53);
      case 43:
         return jjStopAtPos(0, 51);
      case 44:
         return jjStopAtPos(0, 12);
      case 45:
         return jjStartNfaWithStates_0(0, 52, 0);
      case 58:
         return jjMoveStringLiteralDfa1_0(0x1000000000L);
      case 59:
         return jjStopAtPos(0, 13);
      case 60:
         jjmatchedKind = 47;
         return jjMoveStringLiteralDfa1_0(0x1100000000000L);
      case 61:
         return jjStopAtPos(0, 45);
      case 62:
         jjmatchedKind = 46;
         return jjMoveStringLiteralDfa1_0(0x80000000000L);
      case 91:
         return jjStopAtPos(0, 14);
      case 93:
         return jjStopAtPos(0, 15);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x10000000000L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x60000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x10080000L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x40000800000000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x300000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x4000000200000L);
      case 103:
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x48900000L);
      case 109:
         return jjMoveStringLiteralDfa1_0(0x80000000000000L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x40000000000L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x20000000000L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x6000400000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x6000000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x20000000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x2000080000000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x1000000L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x400000000L);
      default :
         return jjMoveNfa_0(3, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 61:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(1, 36);
         else if ((active0 & 0x80000000000L) != 0L)
            return jjStopAtPos(1, 43);
         else if ((active0 & 0x100000000000L) != 0L)
            return jjStopAtPos(1, 44);
         break;
      case 62:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStopAtPos(1, 48);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000001000000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x8006020000L);
      case 102:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(1, 30, 24);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x490080000L);
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000000000L);
      case 107:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x10208100000L);
      case 111:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(1, 35, 24);
         return jjMoveStringLiteralDfa2_0(active0, 0x80040000040000L);
      case 114:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 41, 24);
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000400000L);
      case 115:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(1, 23, 24);
         break;
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x6000200000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x10080000L);
      case 100:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(2, 33, 24);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 40, 24);
         else if ((active0 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 55, 24);
         break;
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000000L);
      case 102:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(2, 25, 24);
         break;
      case 103:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x420000000L);
      case 108:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(2, 24, 24);
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000000000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x200000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x440000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000000L);
      case 116:
         if ((active0 & 0x4000000000L) != 0L)
         {
            jjmatchedKind = 38;
            jjmatchedPos = 2;
         }
         else if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 39, 24);
         else if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 42, 24);
         return jjMoveStringLiteralDfa3_0(active0, 0x200c100000L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000000000L);
      case 118:
         if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 54, 24);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 50:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000L);
      case 95:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000000L);
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x600000L);
      case 101:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(3, 32, 24);
         else if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 49, 24);
         return jjMoveStringLiteralDfa4_0(active0, 0x100000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x400040000L);
      case 110:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(3, 31, 24);
         break;
      case 112:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000000L);
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x10080000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000000000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 50:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000L);
      case 95:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000L);
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000L);
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000L);
      case 101:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(4, 34, 24);
         else if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 50, 24);
         return jjMoveStringLiteralDfa5_0(active0, 0x440000L);
      case 103:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000L);
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000000000L);
      case 110:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(4, 17, 24);
         break;
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000000L);
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x200000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x40000L);
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0x80000L);
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x400000L);
      case 101:
         return jjMoveStringLiteralDfa6_0(active0, 0x100000L);
      case 104:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000L);
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x2010200000L);
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x20000000L);
      case 110:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(5, 26, 24);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x8000000L);
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x20000000L);
      case 110:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(6, 18, 24);
         return jjMoveStringLiteralDfa7_0(active0, 0x2010000000L);
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x200000L);
      case 114:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(6, 20, 24);
         break;
      case 116:
         return jjMoveStringLiteralDfa7_0(active0, 0x80000L);
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x400000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 37, 27);
         return jjMoveStringLiteralDfa8_0(active0, 0x80000L);
      case 110:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(7, 21, 24);
         return jjMoveStringLiteralDfa8_0(active0, 0x20000000L);
      case 114:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(7, 27, 24);
         return jjMoveStringLiteralDfa8_0(active0, 0x400000L);
      case 116:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(7, 28, 24);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjMoveStringLiteralDfa8_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(8, 22, 24);
         else if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(8, 29, 27);
         break;
      case 114:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(8, 19, 24);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 24;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 24:
               case 19:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAddTwoStates(16, 19); }
                  break;
               case 13:
                  { jjCheckNAdd(14); }
                  if (curChar == 39)
                  {
                     if (kind > 57)
                        kind = 57;
                  }
                  break;
               case 26:
               case 18:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 58)
                        kind = 58;
                     { jjCheckNAddStates(0, 2); }
                  }
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 58)
                        kind = 58;
                     { jjCheckNAddTwoStates(16, 19); }
                  }
                  break;
               case 25:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     { jjCheckNAddStates(3, 5); }
                  else if (curChar == 34)
                     { jjCheckNAddTwoStates(11, 7); }
                  if (curChar == 34)
                  {
                     if (kind > 56)
                        kind = 56;
                  }
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 16)
                        kind = 16;
                     { jjCheckNAdd(4); }
                  }
                  else if (curChar == 39)
                     { jjCheckNAddTwoStates(13, 14); }
                  else if (curChar == 34)
                     { jjCheckNAddStates(6, 8); }
                  else if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 0:
                  if (curChar == 45)
                     { jjCheckNAddTwoStates(1, 2); }
                  break;
               case 1:
                  if ((0xfffffffffffffbffL & l) != 0L)
                     { jjCheckNAddTwoStates(1, 2); }
                  break;
               case 2:
                  if (curChar == 10 && kind > 4)
                     kind = 4;
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  { jjCheckNAdd(4); }
                  break;
               case 5:
               case 11:
                  if (curChar == 34)
                     { jjCheckNAddStates(6, 8); }
                  break;
               case 6:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     { jjCheckNAddStates(3, 5); }
                  break;
               case 7:
                  if (curChar == 34)
                     { jjCheckNAddStates(3, 5); }
                  break;
               case 8:
                  if (curChar == 34)
                     { jjCheckNAdd(7); }
                  break;
               case 9:
                  if (curChar == 34 && kind > 56)
                     kind = 56;
                  break;
               case 10:
                  if (curChar == 34)
                     { jjCheckNAddTwoStates(11, 7); }
                  break;
               case 12:
                  if (curChar == 39)
                     { jjCheckNAddTwoStates(13, 14); }
                  break;
               case 14:
                  if (curChar == 39 && kind > 57)
                     kind = 57;
                  break;
               case 17:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAddTwoStates(16, 18); }
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAddTwoStates(22, 23); }
                  break;
               case 23:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAddStates(9, 12); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 24:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 58)
                        kind = 58;
                     { jjCheckNAddTwoStates(16, 19); }
                  }
                  else if (curChar == 95)
                     { jjCheckNAdd(17); }
                  break;
               case 13:
                  jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 26:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 58)
                        kind = 58;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if (curChar == 95)
                     { jjCheckNAdd(17); }
                  break;
               case 27:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 58)
                        kind = 58;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if (curChar == 95)
                     { jjCheckNAdd(17); }
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 58)
                        kind = 58;
                     { jjCheckNAddTwoStates(16, 19); }
                  }
                  break;
               case 25:
               case 6:
                  { jjCheckNAddStates(3, 5); }
                  break;
               case 3:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 58)
                        kind = 58;
                     { jjCheckNAddTwoStates(16, 19); }
                  }
                  else if (curChar == 95)
                     { jjCheckNAdd(21); }
                  break;
               case 1:
                  { jjAddStates(13, 14); }
                  break;
               case 15:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAddTwoStates(16, 19); }
                  break;
               case 16:
                  if (curChar == 95)
                     { jjCheckNAdd(17); }
                  break;
               case 17:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAddTwoStates(16, 18); }
                  break;
               case 18:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 19:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAddTwoStates(16, 19); }
                  break;
               case 20:
                  if (curChar == 95)
                     { jjCheckNAdd(21); }
                  break;
               case 21:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAddTwoStates(22, 23); }
                  break;
               case 22:
                  if (curChar == 95)
                     { jjCheckNAddTwoStates(21, 17); }
                  break;
               case 23:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 58)
                     kind = 58;
                  { jjCheckNAddStates(9, 12); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 13:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 25:
               case 6:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjCheckNAddStates(3, 5); }
                  break;
               case 1:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(13, 14); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 24 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, "\50", "\51", "\42", "\47", 
"\54", "\73", "\133", "\135", null, "\142\145\147\151\156", 
"\142\157\157\154\145\141\156", "\143\150\141\162\141\143\164\145\162", "\151\156\164\145\147\145\162", 
"\146\165\156\143\164\151\157\156", "\160\162\157\143\145\144\165\162\145", "\151\163", "\166\141\154", 
"\162\145\146", "\162\145\164\165\162\156", "\151\156\164\62\143\150\141\162", 
"\143\150\141\162\62\151\156\164", "\163\153\151\160\137\154\151\156\145", "\151\146", "\164\150\145\156", 
"\145\154\163\145", "\145\156\144", "\167\150\151\154\145", "\144\157", "\72\75", 
"\160\165\164\137\154\151\156\145", "\160\165\164", "\147\145\164", "\141\156\144", "\157\162", "\156\157\164", 
"\76\75", "\74\75", "\75", "\76", "\74", "\74\76", "\164\162\165\145", 
"\146\141\154\163\145", "\53", "\55", "\52", "\144\151\166", "\155\157\144", null, null, null, null, };
static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}
static final int[] jjnextStates = {
   16, 19, 18, 8, 6, 9, 6, 9, 10, 16, 19, 22, 23, 1, 2, 
};

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(Exception e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100000600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedPos == 0 && jjmatchedKind > 59)
   {
      jjmatchedKind = 59;
   }
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         matchedToken.specialToken = specialToken;
         return matchedToken;
      }
      else
      {
         if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
         {
            matchedToken = jjFillToken();
            if (specialToken == null)
               specialToken = matchedToken;
            else
            {
               matchedToken.specialToken = specialToken;
               specialToken = (specialToken.next = matchedToken);
            }
            SkipLexicalActions(matchedToken);
         }
         else
            SkipLexicalActions(null);
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 59 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                        System.out.println("ERROR L\u00c9XICO: (" + matchedToken.beginLine + "," + matchedToken.beginColumn + "): s\u00edmbolo no reconocido " + matchedToken.image);
         break;
      default :
         break;
   }
}
static void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
static void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public adacTokenManager(SimpleCharStream stream){

      if (input_stream != null)
        throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);

    input_stream = stream;
  }

  /** Constructor. */
  public adacTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  
  static public void ReInit(SimpleCharStream stream)
  {


    jjmatchedPos =
    jjnewStateCnt =
    0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  static private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 24; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  static public void ReInit(SimpleCharStream stream, int lexState)
  
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public static void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }


/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0x7ffffffffffff01L, 
};
static final long[] jjtoSkip = {
   0x80000000000001eL, 
};
static final long[] jjtoSpecial = {
   0x800000000000010L, 
};
static final long[] jjtoMore = {
   0x0L, 
};
    static protected SimpleCharStream  input_stream;

    static private final int[] jjrounds = new int[24];
    static private final int[] jjstateSet = new int[2 * 24];
    private static final StringBuilder jjimage = new StringBuilder();
    private static StringBuilder image = jjimage;
    private static int jjimageLen;
    private static int lengthOfMatch;
    static protected int curChar;
}
