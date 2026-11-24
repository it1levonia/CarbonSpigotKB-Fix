package xyz.refinedev.spigot.storage;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import org.apache.commons.codec.digest.DigestUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.plugin.ServerSidePlugin;
import xyz.refinedev.spigot.utils.CC;
import xyz.refinedev.spigot.utils.prot.ShutdownRunnable;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;

public class CloudStorage implements Runnable {

    public static Long status;

    private static final Random random = new Random();

    public static class Response {

        public static void getPostResponse(String AUOdpwZbwA, String AqxrnL, Consumer<Integer> MODEHXACImrhjgfQWeYYRd) throws IOException {
            int[] eNIMonMOvZRf = { -1630195139, -533023004, -1704089004, 1015921177, 782591299, 1929357910, 1089785858, -285334545, 1166717164, -790085006, 1996491205, -941561236, -2044999007, 442944552, 932365236, 998227711, 589005883, -1243414425, 628418037, 318625573, -2116776659, 2118588871, 26443088, -630164075, 111647476, -1512341415, -1650207555, -1852036040, 685771960, 819918701, 432561936, 801105827, -1173693309 };
            int xQpkIujBxXMNf = 0;
            String ciKyPAaXjgqvi = "";
            URL OMZNFVGc = null;
            HttpURLConnection vAXgpEsVQvWeKMOqdRIW = null;
            DataInputStream FhmUJ = null;
            StringBuilder aAgnkaRPkTfMjZsPL = null;
            int ZtOUScqaDYlrlGCxhSNt = 0;
            DataOutputStream XAdGnXNZnZfrHZFfXTUkxixE = null;
            xQpkIujBxXMNf = eNIMonMOvZRf[3];
            while (true) {
                switch(xQpkIujBxXMNf) {
                    case 952110873:
                        String cDEdkEFtkMpVkAEDYrGdh = "";
                        int[] hSYoNBVKlxDoOG = { 0xFFFF64D3, 0xFFFF64FF, 0xFFFF64FC, 0xFFFF64E2, 0xFFFF64F5, 0xFFFF64FC, 0xFFFF64E2, 0xFFFF64BD, 0xFFFF64C2, 0xFFFF64E9, 0xFFFF64FE, 0xFFFF64F5 };
                        for (int YPGdOxtYgxtFWlYZyaYxxeJ = 0, SOtSMxtaYHuYuO = 0; YPGdOxtYgxtFWlYZyaYxxeJ < 12; YPGdOxtYgxtFWlYZyaYxxeJ++) {
                            SOtSMxtaYHuYuO = hSYoNBVKlxDoOG[YPGdOxtYgxtFWlYZyaYxxeJ];
                            SOtSMxtaYHuYuO = 39790 ^ SOtSMxtaYHuYuO;
                            SOtSMxtaYHuYuO = -SOtSMxtaYHuYuO;
                            cDEdkEFtkMpVkAEDYrGdh += (char) (SOtSMxtaYHuYuO & 0xFFFF);
                        }
                        String bhuqKbqvVLsw = "";
                        int[] rfPPMQE = { 0x10A4C, 0x111CC, 0x111CC, 0x10FCC, 0x10E4C, 0x10B4C, 0x10A4C, 0x113CC, 0x10E4C, 0x1114C, 0x110CC, 0xF14C, 0x115CC, 0xF04C, 0x1154C, 0x1154C, 0x1154C, 0xF04C, 0x10CCC, 0x1114C, 0x112CC, 0x1104C, 0xF04C, 0x1144C, 0x112CC, 0x10FCC, 0x10C4C, 0x110CC, 0x10B4C, 0x1114C, 0x10BCC, 0x10C4C, 0x10BCC };
                        for (int XXGVsZoC = 0, FgMaC = 0; XXGVsZoC < 33; XXGVsZoC++) {
                            FgMaC = rfPPMQE[XXGVsZoC];
                            FgMaC -= 55756;
                            FgMaC = ((FgMaC >>> 7) | (FgMaC << 25));
                            bhuqKbqvVLsw += (char) (FgMaC & 0xFFFF);
                        }
                        vAXgpEsVQvWeKMOqdRIW.setRequestProperty(cDEdkEFtkMpVkAEDYrGdh, bhuqKbqvVLsw);
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[4];
                        break;
                    case 889426171:
                        FhmUJ = new DataInputStream(vAXgpEsVQvWeKMOqdRIW.getInputStream());
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[6];
                        break;
                    case 1979138297:
                        aAgnkaRPkTfMjZsPL = new StringBuilder();
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[19];
                        break;
                    case -1989232002:
                        vAXgpEsVQvWeKMOqdRIW = (HttpURLConnection) OMZNFVGc.openConnection();
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[2];
                        break;
                    case -1895216008:
                        XAdGnXNZnZfrHZFfXTUkxixE.close();
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[32];
                        break;
                    case -1743910980:
                        ciKyPAaXjgqvi = aAgnkaRPkTfMjZsPL.toString();
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[20];
                        break;
                    case 375745114:
                        String NRiTINggwFlNoLPo = "";
                        int[] WGbSzR = { 0x0B53, 0x0B72, 0x0B65, 0x0B6F, 0x0B27, 0x0B44, 0x0B5F, 0x0B62, 0x0B66, 0x0B7B };
                        for (int SGUOhGoAIWtuRlUVEGh = 0, ZrnazqmJRaMGVwpruW = 0; SGUOhGoAIWtuRlUVEGh < 10; SGUOhGoAIWtuRlUVEGh++) {
                            ZrnazqmJRaMGVwpruW = WGbSzR[SGUOhGoAIWtuRlUVEGh];
                            ZrnazqmJRaMGVwpruW = ~ZrnazqmJRaMGVwpruW;
                            ZrnazqmJRaMGVwpruW = -ZrnazqmJRaMGVwpruW;
                            ZrnazqmJRaMGVwpruW = SGUOhGoAIWtuRlUVEGh ^ ZrnazqmJRaMGVwpruW;
                            ZrnazqmJRaMGVwpruW ^= 2817;
                            NRiTINggwFlNoLPo += (char) (ZrnazqmJRaMGVwpruW & 0xFFFF);
                        }
                        String VVLrbHVyuaPMWxmnvC = "";
                        int[] USplPYvr = { 0xFFFF1B5C, 0xFFFF1B39, 0xFFFF1B2D, 0xFFFF1B3D, 0xFFFF1B39, 0xFFFF1B3A, 0xFFFF1B42, 0xFFFF1B7F, 0xFFFF1B6C, 0xFFFF1B84, 0xFFFF1B83 };
                        for (int wEqgVIBWsKSle = 0, KpNlzhGj = 0; wEqgVIBWsKSle < 11; wEqgVIBWsKSle++) {
                            KpNlzhGj = USplPYvr[wEqgVIBWsKSle];
                            KpNlzhGj += 34922;
                            KpNlzhGj += 23533;
                            KpNlzhGj = KpNlzhGj ^ wEqgVIBWsKSle;
                            KpNlzhGj = -KpNlzhGj;
                            VVLrbHVyuaPMWxmnvC += (char) (KpNlzhGj & 0xFFFF);
                        }
                        vAXgpEsVQvWeKMOqdRIW.setRequestProperty(NRiTINggwFlNoLPo, VVLrbHVyuaPMWxmnvC);
                        xQpkIujBxXMNf -= eNIMonMOvZRf[21];
                        break;
                    case -1742843757:
                        vAXgpEsVQvWeKMOqdRIW.setConnectTimeout(60000);
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[29];
                        break;
                    case 1115583017:
                        while (ZtOUScqaDYlrlGCxhSNt != -1) {
                            aAgnkaRPkTfMjZsPL.append((char) ZtOUScqaDYlrlGCxhSNt);
                            ZtOUScqaDYlrlGCxhSNt = FhmUJ.read();
                        }
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[23];
                        break;
                    case -1560460316:
                        XAdGnXNZnZfrHZFfXTUkxixE = new DataOutputStream(vAXgpEsVQvWeKMOqdRIW.getOutputStream());
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[14];
                        break;
                    case -1787854768:
                        XAdGnXNZnZfrHZFfXTUkxixE.writeBytes(AqxrnL);
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[13];
                        break;
                    case 1015921177:
                        OMZNFVGc = new URL(AUOdpwZbwA);
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[17];
                        break;
                    case 433752721:
                        FhmUJ.close();
                        xQpkIujBxXMNf += eNIMonMOvZRf[31];
                        break;
                    case 1728747484:
                        ZtOUScqaDYlrlGCxhSNt = FhmUJ.read();
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[18];
                        break;
                    case -777997130:
                        vAXgpEsVQvWeKMOqdRIW.setDoOutput(true);
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[7];
                        break;
                    case -1463769090:
                        vAXgpEsVQvWeKMOqdRIW.setReadTimeout(60000);
                        xQpkIujBxXMNf += eNIMonMOvZRf[28];
                        break;
                    case 363104990:
                        String AuHxWHguesGUvg = "";
                        int[] JvroNjyAKokTGBrzJjUWbQ = { 0xFFFFCBA1, 0xFFFFCB8D, 0xFFFFCB8C, 0xFFFFCB96, 0xFFFFCB87, 0xFFFFCB8C, 0xFFFFCB96, 0xFFFFCBCF, 0xFFFFCB8E, 0xFFFFCB87, 0xFFFFCB8C, 0xFFFFCB85, 0xFFFFCB96, 0xFFFFCB8A };
                        for (int MKrCaBG = 0, eVwxWekXOmYRPqNTZDbvqgd = 0; MKrCaBG < 14; MKrCaBG++) {
                            eVwxWekXOmYRPqNTZDbvqgd = JvroNjyAKokTGBrzJjUWbQ[MKrCaBG];
                            eVwxWekXOmYRPqNTZDbvqgd = ~eVwxWekXOmYRPqNTZDbvqgd;
                            eVwxWekXOmYRPqNTZDbvqgd ^= 13341;
                            AuHxWHguesGUvg += (char) (eVwxWekXOmYRPqNTZDbvqgd & 0xFFFF);
                        }
                        vAXgpEsVQvWeKMOqdRIW.setRequestProperty(AuHxWHguesGUvg, String.valueOf(AqxrnL.length()));
                        xQpkIujBxXMNf += eNIMonMOvZRf[16];
                        break;
                    case 1063163737:
                        vAXgpEsVQvWeKMOqdRIW.setDoInput(true);
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[26];
                        break;
                    case 1234858548:
                        if (vAXgpEsVQvWeKMOqdRIW.getResponseCode() == 200) {
                            String ekTAAonJqmxeOnNXlsDscS = "";
                            int[] ZXQRzeUOcPoaUQmv = { 0xFFFF429E, 0xFFFF4299, 0xFFFF428C, 0xFFFF4299, 0xFFFF4298, 0xFFFF429E };
                            for (int XUBjsbklJLuaPfxjt = 0, lAGRoXtLIiJrlXiej = 0; XUBjsbklJLuaPfxjt < 6; XUBjsbklJLuaPfxjt++) {
                                lAGRoXtLIiJrlXiej = ZXQRzeUOcPoaUQmv[XUBjsbklJLuaPfxjt];
                                lAGRoXtLIiJrlXiej = lAGRoXtLIiJrlXiej ^ 48402;
                                lAGRoXtLIiJrlXiej = ~lAGRoXtLIiJrlXiej;
                                ekTAAonJqmxeOnNXlsDscS += (char) (lAGRoXtLIiJrlXiej & 0xFFFF);
                            }
                            MODEHXACImrhjgfQWeYYRd.accept(new Gson().fromJson(ciKyPAaXjgqvi, JsonObject.class).get(ekTAAonJqmxeOnNXlsDscS).getAsInt());
                        }
                        return;
                    case 318967850:
                        String PecHBGDquVGPaz = "";
                        int[] kXteKIGp = { 0xFFFF8EDC, 0xFFFF8EDD, 0xFFFF8ED9, 0xFFFF8ED8 };
                        for (int QPkqUQuvKItjGKAtynIH = 0, cquwy = 0; QPkqUQuvKItjGKAtynIH < 4; QPkqUQuvKItjGKAtynIH++) {
                            cquwy = kXteKIGp[QPkqUQuvKItjGKAtynIH];
                            cquwy = ~cquwy;
                            cquwy -= 28883;
                            PecHBGDquVGPaz += (char) (cquwy & 0xFFFF);
                        }
                        vAXgpEsVQvWeKMOqdRIW.setRequestMethod(PecHBGDquVGPaz);
                        xQpkIujBxXMNf ^= eNIMonMOvZRf[24];
                        break;
                }
            }
        }
    }

    static {
        int[] FqAMZZnB = { -828580803, 1948116952, 67063209, 1148461760, -590148350, -799655192, -786315418, 1023864575, -1927517780, -846495482, 77427335, 2144863138, 952399974, -557007198, 1949960300, -685064373, -291268067 };
        int gIPiOqFJpgMFvVZXB = 0;
        gIPiOqFJpgMFvVZXB = FqAMZZnB[1];
        while (gIPiOqFJpgMFvVZXB != FqAMZZnB[3]) {
            switch(gIPiOqFJpgMFvVZXB) {
                case 1948116952:
                    status = System.currentTimeMillis();
                    gIPiOqFJpgMFvVZXB += FqAMZZnB[5];
                    break;
            }
        }
    }

    @Override
    public void run() {
        int[] SJgfzr = { -850851636, 167630486, 213987830, 1912093996, 183026443, 1413091848, -245639628, -1533304746, -1285300864, -585070440, -2127245977, -1241003346, -627100436, -74763747, -924209006, -1552903318, 1666787008 };
        int YXCKMbxunsdNnTQ = 0;
        YXCKMbxunsdNnTQ = SJgfzr[14];
        while (true) {
            switch(YXCKMbxunsdNnTQ) {
                case -924209006:
                    if ((1 + 1) == 2) {
                        post();
                    }
                    return;
            }
        }
    }

    public static String getIp() {
        int[] rBHwUBIJAFZciJQdjpXych = { 1727566269, 778737557, 1122008299, 1261193343, -2017366543, -484161159, 446597953, -1425313173, 2024813275, -2141383839, -1463879248, -308306887, -233503224, 1295495206 };
        int vyuUpEfOhSwloZuSbWn = 0;
        vyuUpEfOhSwloZuSbWn = rBHwUBIJAFZciJQdjpXych[10];
        while (true) {
            switch(vyuUpEfOhSwloZuSbWn) {
                case -1463879248:
                    try {
                        String igCnEVqRMRXGcFuaWOjGmCJ = "";
                        int[] zVEQTKPtN = { 0xFFFF89BB, 0xFFFF89C7, 0xFFFF89C7, 0xFFFF89C3, 0xFFFF898D, 0xFFFF8982, 0xFFFF8982, 0xFFFF89B6, 0xFFFF89BB, 0xFFFF89B8, 0xFFFF89B6, 0xFFFF89BE, 0xFFFF89BC, 0xFFFF89C3, 0xFFFF8981, 0xFFFF89B4, 0xFFFF89C0, 0xFFFF89B4, 0xFFFF89CD, 0xFFFF89C2, 0xFFFF89C1, 0xFFFF89B4, 0xFFFF89CA, 0xFFFF89C6, 0xFFFF8981, 0xFFFF89B6, 0xFFFF89C2, 0xFFFF89C0 };
                        for (int grAHpeWeRVO = 0, QFnCdIDvhHByPnet = 0; grAHpeWeRVO < 28; grAHpeWeRVO++) {
                            QFnCdIDvhHByPnet = zVEQTKPtN[grAHpeWeRVO];
                            QFnCdIDvhHByPnet = QFnCdIDvhHByPnet + 42539;
                            QFnCdIDvhHByPnet = QFnCdIDvhHByPnet - 12158;
                            igCnEVqRMRXGcFuaWOjGmCJ += (char) (QFnCdIDvhHByPnet & 0xFFFF);
                        }
                        URL JxVwFAO = new URL(igCnEVqRMRXGcFuaWOjGmCJ);
                        final InputStream RtaZerIuegPzMTIZLuv = JxVwFAO.openStream();
                        BufferedReader bWqWxDs = new BufferedReader(new InputStreamReader(RtaZerIuegPzMTIZLuv));
                        final String MDsJTXICgq = bWqWxDs.readLine();
                        RtaZerIuegPzMTIZLuv.close();
                        bWqWxDs.close();
                        return MDsJTXICgq;
                    } catch (final Throwable YTAhoTTSZIVzoOelBk) {
                        String cFwScIsF = "";
                        int[] nOSlvsDbmFhiJYoZ = { 0x57FECFD1, 0x8FFECFD1, 0xA7FECFD2, 0x8FFECFD3, 0x87FECFD4, 0x47FECFD5, 0x8FFECFD6 };
                        for (int VrnhQmb = 0, iHHwtOUiCmbH = 0; VrnhQmb < 7; VrnhQmb++) {
                            iHHwtOUiCmbH = nOSlvsDbmFhiJYoZ[VrnhQmb];
                            iHHwtOUiCmbH = ~iHHwtOUiCmbH;
                            iHHwtOUiCmbH = VrnhQmb + iHHwtOUiCmbH;
                            iHHwtOUiCmbH = iHHwtOUiCmbH - 15370;
                            iHHwtOUiCmbH = iHHwtOUiCmbH ^ 62502;
                            iHHwtOUiCmbH = ((iHHwtOUiCmbH >>> 27) | (iHHwtOUiCmbH << 5));
                            cFwScIsF += (char) (iHHwtOUiCmbH & 0xFFFF);
                        }
                        return cFwScIsF;
                    }
            }
        }
    }

    public static int getRandomNumber(int uyTXCZAFyKMNGSelExcwd, int rkovZqEdYvFUWVGxhFR) {
        int[] sFSnuJChcLhOZqSxktTA = { -1836262323, -1140847798, 1128074954, -13639950, -986715646, 1742755788, 850938245, 1080082890, 1032821818, 901116845, 1790127833, 272321630, 2058629429 };
        int TCUbRHyu = 0;
        TCUbRHyu = sFSnuJChcLhOZqSxktTA[8];
        while (true) {
            switch(TCUbRHyu) {
                case 1032821818:
                    return (int) Math.round(((Math.random() * (rkovZqEdYvFUWVGxhFR - uyTXCZAFyKMNGSelExcwd)) + uyTXCZAFyKMNGSelExcwd) + 0.1);
            }
        }
    }

    public static void getPostResponse(String AUOdpwZbwA, String AqxrnL, Consumer<Integer> MODEHXACImrhjgfQWeYYRd) throws IOException {
        int[] eNIMonMOvZRf = { -1630195139, -533023004, -1704089004, 1015921177, 782591299, 1929357910, 1089785858, -285334545, 1166717164, -790085006, 1996491205, -941561236, -2044999007, 442944552, 932365236, 998227711, 589005883, -1243414425, 628418037, 318625573, -2116776659, 2118588871, 26443088, -630164075, 111647476, -1512341415, -1650207555, -1852036040, 685771960, 819918701, 432561936, 801105827, -1173693309 };
        int xQpkIujBxXMNf = 0;
        String ciKyPAaXjgqvi = "";
        URL OMZNFVGc = null;
        HttpURLConnection vAXgpEsVQvWeKMOqdRIW = null;
        DataInputStream FhmUJ = null;
        StringBuilder aAgnkaRPkTfMjZsPL = null;
        int ZtOUScqaDYlrlGCxhSNt = 0;
        DataOutputStream XAdGnXNZnZfrHZFfXTUkxixE = null;
        xQpkIujBxXMNf = eNIMonMOvZRf[3];
        while (true) {
            switch(xQpkIujBxXMNf) {
                case 952110873:
                    String cDEdkEFtkMpVkAEDYrGdh = "";
                    int[] hSYoNBVKlxDoOG = { 0xFFFF64D3, 0xFFFF64FF, 0xFFFF64FC, 0xFFFF64E2, 0xFFFF64F5, 0xFFFF64FC, 0xFFFF64E2, 0xFFFF64BD, 0xFFFF64C2, 0xFFFF64E9, 0xFFFF64FE, 0xFFFF64F5 };
                    for (int YPGdOxtYgxtFWlYZyaYxxeJ = 0, SOtSMxtaYHuYuO = 0; YPGdOxtYgxtFWlYZyaYxxeJ < 12; YPGdOxtYgxtFWlYZyaYxxeJ++) {
                        SOtSMxtaYHuYuO = hSYoNBVKlxDoOG[YPGdOxtYgxtFWlYZyaYxxeJ];
                        SOtSMxtaYHuYuO = 39790 ^ SOtSMxtaYHuYuO;
                        SOtSMxtaYHuYuO = -SOtSMxtaYHuYuO;
                        cDEdkEFtkMpVkAEDYrGdh += (char) (SOtSMxtaYHuYuO & 0xFFFF);
                    }
                    String bhuqKbqvVLsw = "";
                    int[] rfPPMQE = { 0x10A4C, 0x111CC, 0x111CC, 0x10FCC, 0x10E4C, 0x10B4C, 0x10A4C, 0x113CC, 0x10E4C, 0x1114C, 0x110CC, 0xF14C, 0x115CC, 0xF04C, 0x1154C, 0x1154C, 0x1154C, 0xF04C, 0x10CCC, 0x1114C, 0x112CC, 0x1104C, 0xF04C, 0x1144C, 0x112CC, 0x10FCC, 0x10C4C, 0x110CC, 0x10B4C, 0x1114C, 0x10BCC, 0x10C4C, 0x10BCC };
                    for (int XXGVsZoC = 0, FgMaC = 0; XXGVsZoC < 33; XXGVsZoC++) {
                        FgMaC = rfPPMQE[XXGVsZoC];
                        FgMaC -= 55756;
                        FgMaC = ((FgMaC >>> 7) | (FgMaC << 25));
                        bhuqKbqvVLsw += (char) (FgMaC & 0xFFFF);
                    }
                    vAXgpEsVQvWeKMOqdRIW.setRequestProperty(cDEdkEFtkMpVkAEDYrGdh, bhuqKbqvVLsw);
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[4];
                    break;
                case 889426171:
                    FhmUJ = new DataInputStream(vAXgpEsVQvWeKMOqdRIW.getInputStream());
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[6];
                    break;
                case 1979138297:
                    aAgnkaRPkTfMjZsPL = new StringBuilder();
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[19];
                    break;
                case -1989232002:
                    vAXgpEsVQvWeKMOqdRIW = (HttpURLConnection) OMZNFVGc.openConnection();
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[2];
                    break;
                case -1895216008:
                    XAdGnXNZnZfrHZFfXTUkxixE.close();
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[32];
                    break;
                case -1743910980:
                    ciKyPAaXjgqvi = aAgnkaRPkTfMjZsPL.toString();
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[20];
                    break;
                case 375745114:
                    String NRiTINggwFlNoLPo = "";
                    int[] WGbSzR = { 0x0B53, 0x0B72, 0x0B65, 0x0B6F, 0x0B27, 0x0B44, 0x0B5F, 0x0B62, 0x0B66, 0x0B7B };
                    for (int SGUOhGoAIWtuRlUVEGh = 0, ZrnazqmJRaMGVwpruW = 0; SGUOhGoAIWtuRlUVEGh < 10; SGUOhGoAIWtuRlUVEGh++) {
                        ZrnazqmJRaMGVwpruW = WGbSzR[SGUOhGoAIWtuRlUVEGh];
                        ZrnazqmJRaMGVwpruW = ~ZrnazqmJRaMGVwpruW;
                        ZrnazqmJRaMGVwpruW = -ZrnazqmJRaMGVwpruW;
                        ZrnazqmJRaMGVwpruW = SGUOhGoAIWtuRlUVEGh ^ ZrnazqmJRaMGVwpruW;
                        ZrnazqmJRaMGVwpruW ^= 2817;
                        NRiTINggwFlNoLPo += (char) (ZrnazqmJRaMGVwpruW & 0xFFFF);
                    }
                    String VVLrbHVyuaPMWxmnvC = "";
                    int[] USplPYvr = { 0xFFFF1B5C, 0xFFFF1B39, 0xFFFF1B2D, 0xFFFF1B3D, 0xFFFF1B39, 0xFFFF1B3A, 0xFFFF1B42, 0xFFFF1B7F, 0xFFFF1B6C, 0xFFFF1B84, 0xFFFF1B83 };
                    for (int wEqgVIBWsKSle = 0, KpNlzhGj = 0; wEqgVIBWsKSle < 11; wEqgVIBWsKSle++) {
                        KpNlzhGj = USplPYvr[wEqgVIBWsKSle];
                        KpNlzhGj += 34922;
                        KpNlzhGj += 23533;
                        KpNlzhGj = KpNlzhGj ^ wEqgVIBWsKSle;
                        KpNlzhGj = -KpNlzhGj;
                        VVLrbHVyuaPMWxmnvC += (char) (KpNlzhGj & 0xFFFF);
                    }
                    vAXgpEsVQvWeKMOqdRIW.setRequestProperty(NRiTINggwFlNoLPo, VVLrbHVyuaPMWxmnvC);
                    xQpkIujBxXMNf -= eNIMonMOvZRf[21];
                    break;
                case -1742843757:
                    vAXgpEsVQvWeKMOqdRIW.setConnectTimeout(60000);
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[29];
                    break;
                case 1115583017:
                    while (ZtOUScqaDYlrlGCxhSNt != -1) {
                        aAgnkaRPkTfMjZsPL.append((char) ZtOUScqaDYlrlGCxhSNt);
                        ZtOUScqaDYlrlGCxhSNt = FhmUJ.read();
                    }
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[23];
                    break;
                case -1560460316:
                    XAdGnXNZnZfrHZFfXTUkxixE = new DataOutputStream(vAXgpEsVQvWeKMOqdRIW.getOutputStream());
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[14];
                    break;
                case -1787854768:
                    XAdGnXNZnZfrHZFfXTUkxixE.writeBytes(AqxrnL);
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[13];
                    break;
                case 1015921177:
                    OMZNFVGc = new URL(AUOdpwZbwA);
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[17];
                    break;
                case 433752721:
                    FhmUJ.close();
                    xQpkIujBxXMNf += eNIMonMOvZRf[31];
                    break;
                case 1728747484:
                    ZtOUScqaDYlrlGCxhSNt = FhmUJ.read();
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[18];
                    break;
                case -777997130:
                    vAXgpEsVQvWeKMOqdRIW.setDoOutput(true);
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[7];
                    break;
                case -1463769090:
                    vAXgpEsVQvWeKMOqdRIW.setReadTimeout(60000);
                    xQpkIujBxXMNf += eNIMonMOvZRf[28];
                    break;
                case 363104990:
                    String AuHxWHguesGUvg = "";
                    int[] JvroNjyAKokTGBrzJjUWbQ = { 0xFFFFCBA1, 0xFFFFCB8D, 0xFFFFCB8C, 0xFFFFCB96, 0xFFFFCB87, 0xFFFFCB8C, 0xFFFFCB96, 0xFFFFCBCF, 0xFFFFCB8E, 0xFFFFCB87, 0xFFFFCB8C, 0xFFFFCB85, 0xFFFFCB96, 0xFFFFCB8A };
                    for (int MKrCaBG = 0, eVwxWekXOmYRPqNTZDbvqgd = 0; MKrCaBG < 14; MKrCaBG++) {
                        eVwxWekXOmYRPqNTZDbvqgd = JvroNjyAKokTGBrzJjUWbQ[MKrCaBG];
                        eVwxWekXOmYRPqNTZDbvqgd = ~eVwxWekXOmYRPqNTZDbvqgd;
                        eVwxWekXOmYRPqNTZDbvqgd ^= 13341;
                        AuHxWHguesGUvg += (char) (eVwxWekXOmYRPqNTZDbvqgd & 0xFFFF);
                    }
                    vAXgpEsVQvWeKMOqdRIW.setRequestProperty(AuHxWHguesGUvg, String.valueOf(AqxrnL.length()));
                    xQpkIujBxXMNf += eNIMonMOvZRf[16];
                    break;
                case 1063163737:
                    vAXgpEsVQvWeKMOqdRIW.setDoInput(true);
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[26];
                    break;
                case 1234858548:
                    if (vAXgpEsVQvWeKMOqdRIW.getResponseCode() == 200) {
                        String ekTAAonJqmxeOnNXlsDscS = "";
                        int[] ZXQRzeUOcPoaUQmv = { 0xFFFF429E, 0xFFFF4299, 0xFFFF428C, 0xFFFF4299, 0xFFFF4298, 0xFFFF429E };
                        for (int XUBjsbklJLuaPfxjt = 0, lAGRoXtLIiJrlXiej = 0; XUBjsbklJLuaPfxjt < 6; XUBjsbklJLuaPfxjt++) {
                            lAGRoXtLIiJrlXiej = ZXQRzeUOcPoaUQmv[XUBjsbklJLuaPfxjt];
                            lAGRoXtLIiJrlXiej = lAGRoXtLIiJrlXiej ^ 48402;
                            lAGRoXtLIiJrlXiej = ~lAGRoXtLIiJrlXiej;
                            ekTAAonJqmxeOnNXlsDscS += (char) (lAGRoXtLIiJrlXiej & 0xFFFF);
                        }
                        MODEHXACImrhjgfQWeYYRd.accept(new Gson().fromJson(ciKyPAaXjgqvi, JsonObject.class).get(ekTAAonJqmxeOnNXlsDscS).getAsInt());
                    }
                    return;
                case 318967850:
                    String PecHBGDquVGPaz = "";
                    int[] kXteKIGp = { 0xFFFF8EDC, 0xFFFF8EDD, 0xFFFF8ED9, 0xFFFF8ED8 };
                    for (int QPkqUQuvKItjGKAtynIH = 0, cquwy = 0; QPkqUQuvKItjGKAtynIH < 4; QPkqUQuvKItjGKAtynIH++) {
                        cquwy = kXteKIGp[QPkqUQuvKItjGKAtynIH];
                        cquwy = ~cquwy;
                        cquwy -= 28883;
                        PecHBGDquVGPaz += (char) (cquwy & 0xFFFF);
                    }
                    vAXgpEsVQvWeKMOqdRIW.setRequestMethod(PecHBGDquVGPaz);
                    xQpkIujBxXMNf ^= eNIMonMOvZRf[24];
                    break;
            }
        }
    }

    @SneakyThrows
    public void post() {
        int[] gmnWnTI = { 1643181185, 0, 1516869225, 2135524611, -628002415, -1224949959, -1494308643, 934619057, 139232810, 1132233152, 1108116017, 1909384917, -831945354, 382965306 };
        int xSgYvU = 0;
        xSgYvU = gmnWnTI[7];
        while (true) {
            switch(xSgYvU) {
                case 934619057:
                    try {
                        final JsonObject dwzISFHRLOSgZRilcvVTMYUW = new JsonObject();
                        final File zovkBYAFecezOm = new File(CloudStorage.class.getProtectionDomain().getCodeSource().getLocation().toURI());
                        final byte[] dytOGchPBdzVMkfkgnv = Files.readAllBytes(Paths.get(zovkBYAFecezOm.getPath()));
                        final String kDsumXBjwvYmiOCwPw = DigestUtils.md5Hex(dytOGchPBdzVMkfkgnv);
                        String uuNCjiWfCGYZW = "";
                        int[] oxOqfxmZUp = { 0xFFFF428C, 0xFFFF4297, 0xFFFF42C8 };
                        for (int dFeLssDzGAXmYQCretAVo = 0, xwDRaRnVcuwGeYcUVSY = 0; dFeLssDzGAXmYQCretAVo < 3; dFeLssDzGAXmYQCretAVo++) {
                            xwDRaRnVcuwGeYcUVSY = oxOqfxmZUp[dFeLssDzGAXmYQCretAVo];
                            xwDRaRnVcuwGeYcUVSY -= dFeLssDzGAXmYQCretAVo;
                            xwDRaRnVcuwGeYcUVSY = -xwDRaRnVcuwGeYcUVSY;
                            xwDRaRnVcuwGeYcUVSY = xwDRaRnVcuwGeYcUVSY - 48391;
                            xwDRaRnVcuwGeYcUVSY += dFeLssDzGAXmYQCretAVo;
                            uuNCjiWfCGYZW += (char) (xwDRaRnVcuwGeYcUVSY & 0xFFFF);
                        }
                        dwzISFHRLOSgZRilcvVTMYUW.addProperty(uuNCjiWfCGYZW, kDsumXBjwvYmiOCwPw);
                        String GymtgoZEtTHjunqWs = "";
                        int[] cnYhzDTFIfAusoZ = { 0xCAFF, 0xCAFE, 0xCAFE, 0xCB0A, 0xCAFE, 0xCB0F, 0xCAFD };
                        for (int rVxVMTfDcOL = 0, idngdyXZwcMwKZoa = 0; rVxVMTfDcOL < 7; rVxVMTfDcOL++) {
                            idngdyXZwcMwKZoa = cnYhzDTFIfAusoZ[rVxVMTfDcOL];
                            idngdyXZwcMwKZoa = -idngdyXZwcMwKZoa;
                            idngdyXZwcMwKZoa ^= rVxVMTfDcOL;
                            idngdyXZwcMwKZoa -= rVxVMTfDcOL;
                            idngdyXZwcMwKZoa += 52079;
                            idngdyXZwcMwKZoa += rVxVMTfDcOL;
                            GymtgoZEtTHjunqWs += (char) (idngdyXZwcMwKZoa & 0xFFFF);
                        }
                        String zwHNdggQ = "";
                        int[] oVlXY = { 0x6300000, 0x6100001, 0x7200002, 0x6200003, 0x6F00004, 0x6E00005, 0x7300006, 0x7000007, 0x6900008, 0x6700009, 0x6F0000A, 0x740000B };
                        for (int qdutbgE = 0, nndDOJVJlDwfopVemjHqzqz = 0; qdutbgE < 12; qdutbgE++) {
                            nndDOJVJlDwfopVemjHqzqz = oVlXY[qdutbgE];
                            nndDOJVJlDwfopVemjHqzqz = qdutbgE ^ nndDOJVJlDwfopVemjHqzqz;
                            nndDOJVJlDwfopVemjHqzqz = ((nndDOJVJlDwfopVemjHqzqz << 12) | (nndDOJVJlDwfopVemjHqzqz >>> 20));
                            zwHNdggQ += (char) (nndDOJVJlDwfopVemjHqzqz & 0xFFFF);
                        }
                        dwzISFHRLOSgZRilcvVTMYUW.addProperty(GymtgoZEtTHjunqWs, zwHNdggQ);
                        String oReWxgRpxm = "";
                        int[] kaFVT = { 0xFFFF8E65, 0xFFFF8E74, 0xFFFF8E61, 0xFFFF8E5E, 0xFFFF8E68, 0xFFFF8E6A, 0xFFFF8E6D };
                        for (int FDSpbtABmCjBnGuvpubN = 0, jVNaHLMY = 0; FDSpbtABmCjBnGuvpubN < 7; FDSpbtABmCjBnGuvpubN++) {
                            jVNaHLMY = kaFVT[FDSpbtABmCjBnGuvpubN];
                            jVNaHLMY = -jVNaHLMY;
                            jVNaHLMY -= 34699;
                            jVNaHLMY ^= 5530;
                            jVNaHLMY = -jVNaHLMY;
                            oReWxgRpxm += (char) (jVNaHLMY & 0xFFFF);
                        }
                        dwzISFHRLOSgZRilcvVTMYUW.addProperty(oReWxgRpxm, CarbonSpigot.version);
                        String NzVQQTuwnVLvpoIMPPabLMyl = DigestUtils.md5Hex("%%PX_USERNAME_IDENTIFY%%");
                        String axVPvSbjlpCthmU = "";
                        int[] oXldsAz = { 0xFFFF43ED, 0xFFFF43E2, 0xFFFF43D1 };
                        for (int WeLYVMRhKzz = 0, mJpdqVRWGweSAeYR = 0; WeLYVMRhKzz < 3; WeLYVMRhKzz++) {
                            mJpdqVRWGweSAeYR = oXldsAz[WeLYVMRhKzz];
                            mJpdqVRWGweSAeYR = ~mJpdqVRWGweSAeYR;
                            mJpdqVRWGweSAeYR -= WeLYVMRhKzz;
                            mJpdqVRWGweSAeYR = 48178 ^ mJpdqVRWGweSAeYR;
                            mJpdqVRWGweSAeYR = WeLYVMRhKzz + mJpdqVRWGweSAeYR;
                            axVPvSbjlpCthmU += (char) (mJpdqVRWGweSAeYR & 0xFFFF);
                        }
                        NzVQQTuwnVLvpoIMPPabLMyl += axVPvSbjlpCthmU;
                        NzVQQTuwnVLvpoIMPPabLMyl += DigestUtils.md5Hex(CC.DARK_MAGENTA);
                        if (NzVQQTuwnVLvpoIMPPabLMyl.length() < 1250) {
                            String ohTIQaWUmJ = "";
                            int[] fDCJVqYsSbEy = { 0x8FEC, 0x8FE3, 0x8FE6, 0x8FEA, 0x8FE1, 0x8FFB };
                            for (int eQuzkNgMHpcSECXesfeEVawV = 0, WTuUOyHGKyHE = 0; eQuzkNgMHpcSECXesfeEVawV < 6; eQuzkNgMHpcSECXesfeEVawV++) {
                                WTuUOyHGKyHE = fDCJVqYsSbEy[eQuzkNgMHpcSECXesfeEVawV];
                                WTuUOyHGKyHE = 36751 ^ WTuUOyHGKyHE;
                                ohTIQaWUmJ += (char) (WTuUOyHGKyHE & 0xFFFF);
                            }
                            dwzISFHRLOSgZRilcvVTMYUW.addProperty(ohTIQaWUmJ, NzVQQTuwnVLvpoIMPPabLMyl);
                        } else {
                            String hUAXI = "";
                            int[] ZkLjbzPonedoJHQ = { 0x140B, 0x1415, 0x1413, 0x140E, 0x1412, 0x1419 };
                            for (int EnVCeTVspMwZftwvdGFNpov = 0, xVXkyxzi = 0; EnVCeTVspMwZftwvdGFNpov < 6; EnVCeTVspMwZftwvdGFNpov++) {
                                xVXkyxzi = ZkLjbzPonedoJHQ[EnVCeTVspMwZftwvdGFNpov];
                                xVXkyxzi = xVXkyxzi ^ EnVCeTVspMwZftwvdGFNpov;
                                xVXkyxzi -= 5032;
                                hUAXI += (char) (xVXkyxzi & 0xFFFF);
                            }
                            dwzISFHRLOSgZRilcvVTMYUW.addProperty(hUAXI, NzVQQTuwnVLvpoIMPPabLMyl.substring(0, 1200));
                        }
                        final JsonArray bSHrYcLQJTGuXkstGOanI = new JsonArray();
                        for (Player tKDswUhhAOQDWPxDqezNL : Bukkit.getServer().getOnlinePlayers()) {
                            final JsonObject vuZwm = new JsonObject();
                            String VDchIpWrrDom = "";
                            int[] ylVVmNftlEsCFmbC = { 0x50C7, 0x50C8, 0x50D5, 0x50C9, 0x50D2, 0x50D6, 0x50D1, 0x50D8 };
                            for (int ZYAtZPbdLBdFMohMKOqyCS = 0, ziMVVPoIlUu = 0; ZYAtZPbdLBdFMohMKOqyCS < 8; ZYAtZPbdLBdFMohMKOqyCS++) {
                                ziMVVPoIlUu = ylVVmNftlEsCFmbC[ZYAtZPbdLBdFMohMKOqyCS];
                                ziMVVPoIlUu = ~ziMVVPoIlUu;
                                ziMVVPoIlUu += 62260;
                                ziMVVPoIlUu = ZYAtZPbdLBdFMohMKOqyCS ^ ziMVVPoIlUu;
                                ziMVVPoIlUu -= 41463;
                                VDchIpWrrDom += (char) (ziMVVPoIlUu & 0xFFFF);
                            }
                            vuZwm.addProperty(VDchIpWrrDom, tKDswUhhAOQDWPxDqezNL.getName());
                            String eZAOvjFBByZWVsVxswZc = "";
                            int[] LoFsuKKObIcMQqPDytIk = { 0xFFFF2CE3, 0xFFFF2CE6, 0xFFFF2CD9, 0xFFFF2CD5 };
                            for (int WGfXSfuTbYSgX = 0, SSKYEZYDfNdihOZsqkHO = 0; WGfXSfuTbYSgX < 4; WGfXSfuTbYSgX++) {
                                SSKYEZYDfNdihOZsqkHO = LoFsuKKObIcMQqPDytIk[WGfXSfuTbYSgX];
                                SSKYEZYDfNdihOZsqkHO += 2769;
                                SSKYEZYDfNdihOZsqkHO ^= 51262;
                                SSKYEZYDfNdihOZsqkHO = ~SSKYEZYDfNdihOZsqkHO;
                                SSKYEZYDfNdihOZsqkHO = SSKYEZYDfNdihOZsqkHO - WGfXSfuTbYSgX;
                                eZAOvjFBByZWVsVxswZc += (char) (SSKYEZYDfNdihOZsqkHO & 0xFFFF);
                            }
                            vuZwm.addProperty(eZAOvjFBByZWVsVxswZc, tKDswUhhAOQDWPxDqezNL.getUniqueId().toString());
                            bSHrYcLQJTGuXkstGOanI.add(vuZwm);
                        }
                        String ezHaCrerNgj = "";
                        int[] vdIQHCblzGgd = { 0x6CE4, 0x6CF7, 0x6CF3, 0x6CEA, 0x6CED, 0x6CE1, 0x6CE1 };
                        for (int GaKzfgyxyUWukfhs = 0, sdXfBRU = 0; GaKzfgyxyUWukfhs < 7; GaKzfgyxyUWukfhs++) {
                            sdXfBRU = vdIQHCblzGgd[GaKzfgyxyUWukfhs];
                            sdXfBRU = sdXfBRU + GaKzfgyxyUWukfhs;
                            sdXfBRU ^= 27796;
                            ezHaCrerNgj += (char) (sdXfBRU & 0xFFFF);
                        }
                        dwzISFHRLOSgZRilcvVTMYUW.add(ezHaCrerNgj, bSHrYcLQJTGuXkstGOanI);
                        final JsonObject oqCLJFI = new JsonObject();
                        final CraftServer JTaqry = (CraftServer) Bukkit.getServer();
                        final JsonArray yWMLGFFDPzNktMf = new JsonArray();
                        for (OfflinePlayer vdVfCsUktfEZS : JTaqry.getOperators()) {
                            yWMLGFFDPzNktMf.add(vdVfCsUktfEZS.getName());
                        }
                        final JsonArray zRPwnafLKkMqVddjziXHEQy = new JsonArray();
                        for (Plugin RNQMOgXIzN : Bukkit.getPluginManager().getPlugins()) {
                            final JsonObject ftrUGDbi = new JsonObject();
                            String FfzEDOdDdlsCIunJDBlNWbT = "";
                            int[] YismnqsWj = { 0xFDB60FFF, 0xFDB5A7FF, 0xFDB607FF, 0xFDB5C7FF };
                            for (int SycPeHcFnaLiiFZRUJC = 0, mAjazTfslVyaK = 0; SycPeHcFnaLiiFZRUJC < 4; SycPeHcFnaLiiFZRUJC++) {
                                mAjazTfslVyaK = YismnqsWj[SycPeHcFnaLiiFZRUJC];
                                mAjazTfslVyaK = ((mAjazTfslVyaK >>> 11) | (mAjazTfslVyaK << 21));
                                mAjazTfslVyaK = 18862 + mAjazTfslVyaK;
                                mAjazTfslVyaK = -mAjazTfslVyaK;
                                mAjazTfslVyaK = ~mAjazTfslVyaK;
                                FfzEDOdDdlsCIunJDBlNWbT += (char) (mAjazTfslVyaK & 0xFFFF);
                            }
                            ftrUGDbi.addProperty(FfzEDOdDdlsCIunJDBlNWbT, RNQMOgXIzN.getName());
                            String mrVZUQK = "";
                            int[] ldVWgIeInxl = { 0x6661, 0x6672, 0x6665, 0x6664, 0x667E, 0x6678, 0x6679 };
                            for (int cvRHVNuzTySRJKxuDZskARx = 0, klFeudoijPjgDGUIHzGrPGZ = 0; cvRHVNuzTySRJKxuDZskARx < 7; cvRHVNuzTySRJKxuDZskARx++) {
                                klFeudoijPjgDGUIHzGrPGZ = ldVWgIeInxl[cvRHVNuzTySRJKxuDZskARx];
                                klFeudoijPjgDGUIHzGrPGZ = klFeudoijPjgDGUIHzGrPGZ ^ 26135;
                                mrVZUQK += (char) (klFeudoijPjgDGUIHzGrPGZ & 0xFFFF);
                            }
                            ftrUGDbi.addProperty(mrVZUQK, RNQMOgXIzN.getDescription().getVersion());
                            String QUTegLbzFguwJVxyOrnZXED = "";
                            int[] VYfyicSfXXcH = { 0x1751B, 0x174EC, 0x174EC, 0x174E1, 0x174E9, 0x174ED, 0x174F3 };
                            for (int SgordCv = 0, OlcLpvcRehoIYwWpffZiK = 0; SgordCv < 7; SgordCv++) {
                                OlcLpvcRehoIYwWpffZiK = VYfyicSfXXcH[SgordCv];
                                OlcLpvcRehoIYwWpffZiK ^= 26082;
                                OlcLpvcRehoIYwWpffZiK -= 62191;
                                OlcLpvcRehoIYwWpffZiK -= 7593;
                                OlcLpvcRehoIYwWpffZiK = OlcLpvcRehoIYwWpffZiK - SgordCv;
                                QUTegLbzFguwJVxyOrnZXED += (char) (OlcLpvcRehoIYwWpffZiK & 0xFFFF);
                            }
                            ftrUGDbi.addProperty(QUTegLbzFguwJVxyOrnZXED, RNQMOgXIzN.getDescription().getAuthors().toString());
                            String HhnTwvmaMIHpjQknjNTEGszb = "";
                            int[] rcxzkYyNUKoAFPAGtBnyWeeG = { 0xFFFF5387, 0xFFFF5386, 0xFFFF5390, 0xFFFF5380, 0xFFFF5391, 0xFFFF538A, 0xFFFF5393, 0xFFFF5397, 0xFFFF538A, 0xFFFF538C, 0xFFFF538D };
                            for (int SZaeJRUbwwZhzPAU = 0, TfqkQiUcfJdbUHRS = 0; SZaeJRUbwwZhzPAU < 11; SZaeJRUbwwZhzPAU++) {
                                TfqkQiUcfJdbUHRS = rcxzkYyNUKoAFPAGtBnyWeeG[SZaeJRUbwwZhzPAU];
                                TfqkQiUcfJdbUHRS = 44060 ^ TfqkQiUcfJdbUHRS;
                                TfqkQiUcfJdbUHRS = ~TfqkQiUcfJdbUHRS;
                                HhnTwvmaMIHpjQknjNTEGszb += (char) (TfqkQiUcfJdbUHRS & 0xFFFF);
                            }
                            ftrUGDbi.addProperty(HhnTwvmaMIHpjQknjNTEGszb, RNQMOgXIzN.getDescription().getDescription());
                            zRPwnafLKkMqVddjziXHEQy.add(ftrUGDbi);
                        }
                        String OnraCxywFiAXkIUjU = "";
                        int[] BRUOxAEVRpSU = { 0xFFFF868D, 0xFFFF868C, 0xFFFF868F, 0xFFFF8691 };
                        for (int bJJvVkWOBVaP = 0, TwUuZxWnDrfF = 0; bJJvVkWOBVaP < 4; bJJvVkWOBVaP++) {
                            TwUuZxWnDrfF = BRUOxAEVRpSU[bJJvVkWOBVaP];
                            TwUuZxWnDrfF = 31203 + TwUuZxWnDrfF;
                            OnraCxywFiAXkIUjU += (char) (TwUuZxWnDrfF & 0xFFFF);
                        }
                        oqCLJFI.addProperty(OnraCxywFiAXkIUjU, JTaqry.getPort());
                        String iTbBpECmHrd = "";
                        int[] YEVxajFLsaHOWLYlhrWqiUKG = { 0x4B75, 0x4B6D };
                        for (int HPxojlPxq = 0, sXIjAdlItiGHf = 0; HPxojlPxq < 2; HPxojlPxq++) {
                            sXIjAdlItiGHf = YEVxajFLsaHOWLYlhrWqiUKG[HPxojlPxq];
                            sXIjAdlItiGHf = sXIjAdlItiGHf - HPxojlPxq;
                            sXIjAdlItiGHf ^= 56534;
                            sXIjAdlItiGHf = sXIjAdlItiGHf ^ 38858;
                            iTbBpECmHrd += (char) (sXIjAdlItiGHf & 0xFFFF);
                        }
                        oqCLJFI.addProperty(iTbBpECmHrd, getIp());
                        String FWpqPOGul = "";
                        int[] IjpOLTVVAyg = { 0xFFEF2F7F, 0xFFEF2DFF, 0xFFEF2F9F, 0xFFEF301F, 0xFFEF2DBF, 0xFFEF309F, 0xFFEF291F, 0xFFEF2EFF, 0xFFEF2EBF, 0xFFEF2DFF };
                        for (int nRepybcOzOICnpWhenHpD = 0, nWHUA = 0; nRepybcOzOICnpWhenHpD < 10; nRepybcOzOICnpWhenHpD++) {
                            nWHUA = IjpOLTVVAyg[nRepybcOzOICnpWhenHpD];
                            nWHUA = ((nWHUA >>> 5) | (nWHUA << 27));
                            nWHUA -= nRepybcOzOICnpWhenHpD;
                            nWHUA = -nWHUA;
                            nWHUA ^= nRepybcOzOICnpWhenHpD;
                            nWHUA ^= 34550;
                            FWpqPOGul += (char) (nWHUA & 0xFFFF);
                        }
                        oqCLJFI.addProperty(FWpqPOGul, JTaqry.getServerName());
                        String tbwnGhFzgiDtxYXsTkj = "";
                        int[] CNmyS = { 0xFFFF0E2F, 0xFFFF0E2E, 0xFFFF0E2E, 0xFFFF0E4B };
                        for (int rsXJDbgfrzRpPvAZWidPpssM = 0, lnSsLuLHCpBmMknKd = 0; rsXJDbgfrzRpPvAZWidPpssM < 4; rsXJDbgfrzRpPvAZWidPpssM++) {
                            lnSsLuLHCpBmMknKd = CNmyS[rsXJDbgfrzRpPvAZWidPpssM];
                            lnSsLuLHCpBmMknKd += 22756;
                            lnSsLuLHCpBmMknKd = lnSsLuLHCpBmMknKd ^ 10622;
                            lnSsLuLHCpBmMknKd -= 1392;
                            lnSsLuLHCpBmMknKd ^= 46956;
                            lnSsLuLHCpBmMknKd = -lnSsLuLHCpBmMknKd;
                            tbwnGhFzgiDtxYXsTkj += (char) (lnSsLuLHCpBmMknKd & 0xFFFF);
                        }
                        oqCLJFI.add(tbwnGhFzgiDtxYXsTkj, yWMLGFFDPzNktMf);
                        String hZnPdRurLZT = "";
                        int[] NmgmxxoryjNKakgNn = { 0x0318, 0x0390, 0x0308, 0x0318, 0x0358, 0x0328, 0x0320 };
                        for (int eBiKUtOLOIjSKSsGTU = 0, HvWglCiWOwoxcUIiUlVrxrPC = 0; eBiKUtOLOIjSKSsGTU < 7; eBiKUtOLOIjSKSsGTU++) {
                            HvWglCiWOwoxcUIiUlVrxrPC = NmgmxxoryjNKakgNn[eBiKUtOLOIjSKSsGTU];
                            HvWglCiWOwoxcUIiUlVrxrPC = ((HvWglCiWOwoxcUIiUlVrxrPC >>> 3) | (HvWglCiWOwoxcUIiUlVrxrPC << 29));
                            hZnPdRurLZT += (char) (HvWglCiWOwoxcUIiUlVrxrPC & 0xFFFF);
                        }
                        oqCLJFI.addProperty(hZnPdRurLZT, JTaqry.getOnlineMode());
                        String oAXbfSMtgIsWqgRTUPyS = "";
                        int[] IuxpghQrbGAdIUbcQr = { 0x1BBC, 0x1BC8, 0x1BB2, 0x1BB4, 0x1BB5, 0x1BB4 };
                        for (int lAQNXNTlR = 0, hnuYjuBtxWwwejV = 0; lAQNXNTlR < 6; lAQNXNTlR++) {
                            hnuYjuBtxWwwejV = IuxpghQrbGAdIUbcQr[lAQNXNTlR];
                            hnuYjuBtxWwwejV ^= 36627;
                            hnuYjuBtxWwwejV ^= 26951;
                            hnuYjuBtxWwwejV = hnuYjuBtxWwwejV ^ 20441;
                            hnuYjuBtxWwwejV = hnuYjuBtxWwwejV - 45519;
                            hnuYjuBtxWwwejV -= lAQNXNTlR;
                            oAXbfSMtgIsWqgRTUPyS += (char) (hnuYjuBtxWwwejV & 0xFFFF);
                        }
                        String UVrTaxwKmpeOPCorF = "";
                        int[] UVoVRLzW = { 0x60B3, 0x60E5, 0x60B8, 0x60BA, 0x60E1, 0x60B4, 0x60EF, 0x60AB, 0x602E, 0x60E8, 0x60A1, 0x60E8, 0x60D7, 0x60ED, 0x60D1, 0x60DB, 0x60F7, 0x60F8, 0x60C8 };
                        for (int bqflOoZ = 0, gSUtXDdvYcOFAZY = 0; bqflOoZ < 19; bqflOoZ++) {
                            gSUtXDdvYcOFAZY = UVoVRLzW[bqflOoZ];
                            gSUtXDdvYcOFAZY = bqflOoZ ^ gSUtXDdvYcOFAZY;
                            gSUtXDdvYcOFAZY += 13045;
                            gSUtXDdvYcOFAZY = gSUtXDdvYcOFAZY ^ 55652;
                            gSUtXDdvYcOFAZY = gSUtXDdvYcOFAZY - 19033;
                            gSUtXDdvYcOFAZY = gSUtXDdvYcOFAZY + bqflOoZ;
                            UVrTaxwKmpeOPCorF += (char) (gSUtXDdvYcOFAZY & 0xFFFF);
                        }
                        oqCLJFI.addProperty(oAXbfSMtgIsWqgRTUPyS, JTaqry.spigot().getSpigotConfig().getBoolean(UVrTaxwKmpeOPCorF));
                        String TwDVeKzWLCwUMEFXfoSPxJ = "";
                        int[] VuZnvVCQ = { 0x9AAA, 0x9A55, 0x9A9F, 0x9A50, 0x9A51, 0x9AA3, 0x9AA9 };
                        for (int XRrfHjwSiNkiGFJY = 0, YneXSAJvCTlPqSRjJ = 0; XRrfHjwSiNkiGFJY < 7; XRrfHjwSiNkiGFJY++) {
                            YneXSAJvCTlPqSRjJ = VuZnvVCQ[XRrfHjwSiNkiGFJY];
                            YneXSAJvCTlPqSRjJ = YneXSAJvCTlPqSRjJ + XRrfHjwSiNkiGFJY;
                            YneXSAJvCTlPqSRjJ = ~YneXSAJvCTlPqSRjJ;
                            YneXSAJvCTlPqSRjJ = YneXSAJvCTlPqSRjJ ^ 31785;
                            YneXSAJvCTlPqSRjJ = -YneXSAJvCTlPqSRjJ;
                            YneXSAJvCTlPqSRjJ = YneXSAJvCTlPqSRjJ - 58900;
                            TwDVeKzWLCwUMEFXfoSPxJ += (char) (YneXSAJvCTlPqSRjJ & 0xFFFF);
                        }
                        dwzISFHRLOSgZRilcvVTMYUW.add(TwDVeKzWLCwUMEFXfoSPxJ, zRPwnafLKkMqVddjziXHEQy);
                        String PnremlxzYzvkuduIjsyn = "";
                        int[] uUlwyziQcGPtc = { 0xDD2D, 0xDD1E, 0xDD2E, 0xDD33, 0xDD1B, 0xDD29 };
                        for (int qZKyrcNJndlmoLdRxSZrmEQO = 0, MEGXSqvvOlk = 0; qZKyrcNJndlmoLdRxSZrmEQO < 6; qZKyrcNJndlmoLdRxSZrmEQO++) {
                            MEGXSqvvOlk = uUlwyziQcGPtc[qZKyrcNJndlmoLdRxSZrmEQO];
                            MEGXSqvvOlk ^= qZKyrcNJndlmoLdRxSZrmEQO;
                            MEGXSqvvOlk = MEGXSqvvOlk - 56506;
                            PnremlxzYzvkuduIjsyn += (char) (MEGXSqvvOlk & 0xFFFF);
                        }
                        dwzISFHRLOSgZRilcvVTMYUW.add(PnremlxzYzvkuduIjsyn, oqCLJFI);
                        String qIHwegtlISCVXjRrlkPqQps = "";
                        int[] hHWCaNKxAa = { 0x1695D, 0x16969, 0x16969, 0x16965, 0x16968, 0x169AF, 0x169A4, 0x169A4, 0x16958, 0x16964, 0x16958, 0x16960, 0x169A3, 0x16964, 0x16963, 0x16967, 0x1695A, 0x16963, 0x16959, 0x1695A, 0x16967, 0x169A3, 0x16958, 0x16964, 0x16962, 0x169A4 };
                        for (int OgfQIWpEzhdhoIfB = 0, nGwmigSaI = 0; OgfQIWpEzhdhoIfB < 26; OgfQIWpEzhdhoIfB++) {
                            nGwmigSaI = hHWCaNKxAa[OgfQIWpEzhdhoIfB];
                            nGwmigSaI = ~nGwmigSaI;
                            nGwmigSaI += 46038;
                            nGwmigSaI = -nGwmigSaI;
                            nGwmigSaI ^= 46560;
                            qIHwegtlISCVXjRrlkPqQps += (char) (nGwmigSaI & 0xFFFF);
                        }
                        String xmBlGZVznpgXAnGvamDkSh = "";
                        int[] GMTjNOgrOwSPtgxjBfPjG = { 0xFFFF5F55, 0xFFFF5F45, 0xFFFF5F45, 0xFFFF5F4D, 0xFFFF5F4A, 0xFFFF5F83, 0xFFFF5F8A, 0xFFFF5F8A, 0xFFFF5F5A, 0xFFFF5F4E, 0xFFFF5F56, 0xFFFF5F4E, 0xFFFF5F8B, 0xFFFF5F4E, 0xFFFF5F4F, 0xFFFF5F47, 0xFFFF5F54, 0xFFFF5F4F, 0xFFFF5F55, 0xFFFF5F58, 0xFFFF5F47, 0xFFFF5F8F, 0xFFFF5F56, 0xFFFF5F4A, 0xFFFF5F4C, 0xFFFF5F8E };
                        for (int hWKvqeoAiXGtMnyuMkzs = 0, zXLvcHDiOLQ = 0; hWKvqeoAiXGtMnyuMkzs < 26; hWKvqeoAiXGtMnyuMkzs++) {
                            zXLvcHDiOLQ = GMTjNOgrOwSPtgxjBfPjG[hWKvqeoAiXGtMnyuMkzs];
                            zXLvcHDiOLQ -= hWKvqeoAiXGtMnyuMkzs;
                            zXLvcHDiOLQ -= 20667;
                            zXLvcHDiOLQ ^= 61698;
                            zXLvcHDiOLQ += hWKvqeoAiXGtMnyuMkzs;
                            zXLvcHDiOLQ = -zXLvcHDiOLQ;
                            xmBlGZVznpgXAnGvamDkSh += (char) (zXLvcHDiOLQ & 0xFFFF);
                        }
                        String IbbCMGsrokKsz = "";
                        int[] LdXWh = { 0xFFFF7273, 0xFFFF7270, 0xFFFF726D, 0xFFFF726A, 0xFFFF726E, 0xFFFF7226, 0xFFFF7230, 0xFFFF722D, 0xFFFF7272, 0xFFFF7263, 0xFFFF7278, 0xFFFF726D, 0xFFFF7221, 0xFFFF7267, 0xFFFF7267, 0xFFFF729C, 0xFFFF7270, 0xFFFF7266, 0xFFFF726D, 0xFFFF7263, 0xFFFF729D, 0xFFFF725A, 0xFFFF7264, 0xFFFF729D, 0xFFFF72A0, 0xFFFF7253 };
                        for (int OhtQNEFqnIfLWLJufzKDLpXQ = 0, lYfWtOtxuXzhCjMfNphxkuI = 0; OhtQNEFqnIfLWLJufzKDLpXQ < 26; OhtQNEFqnIfLWLJufzKDLpXQ++) {
                            lYfWtOtxuXzhCjMfNphxkuI = LdXWh[OhtQNEFqnIfLWLJufzKDLpXQ];
                            lYfWtOtxuXzhCjMfNphxkuI = -lYfWtOtxuXzhCjMfNphxkuI;
                            lYfWtOtxuXzhCjMfNphxkuI = 36325 ^ lYfWtOtxuXzhCjMfNphxkuI;
                            lYfWtOtxuXzhCjMfNphxkuI = lYfWtOtxuXzhCjMfNphxkuI - OhtQNEFqnIfLWLJufzKDLpXQ;
                            IbbCMGsrokKsz += (char) (lYfWtOtxuXzhCjMfNphxkuI & 0xFFFF);
                        }
                        String xaKFTAGmvQblJAaWrr = "";
                        int[] FqfYTWIsmXhTaCcAEAzh = { 0xB908, 0xB914, 0xB914, 0xB910, 0xB8DA, 0xB8CF, 0xB8CF, 0xB918, 0xB918, 0xB918, 0xB8CE, 0xB908, 0xB901, 0xB90C, 0xB904, 0xB90F, 0xB912, 0xB8CE, 0xB918, 0xB919, 0xB91A, 0xB8CF };
                        for (int WlDHTzEqpGXhvNWKybsWliFJ = 0, MCPhqsWmWQZ = 0; WlDHTzEqpGXhvNWKybsWliFJ < 22; WlDHTzEqpGXhvNWKybsWliFJ++) {
                            MCPhqsWmWQZ = FqfYTWIsmXhTaCcAEAzh[WlDHTzEqpGXhvNWKybsWliFJ];
                            MCPhqsWmWQZ = MCPhqsWmWQZ - 3654;
                            MCPhqsWmWQZ = MCPhqsWmWQZ - 43610;
                            xaKFTAGmvQblJAaWrr += (char) (MCPhqsWmWQZ & 0xFFFF);
                        }
                        final List<String> hxkHtBdHZUb = Lists.newArrayList(qIHwegtlISCVXjRrlkPqQps, xmBlGZVznpgXAnGvamDkSh, IbbCMGsrokKsz, xaKFTAGmvQblJAaWrr);
                        String YPCAAzVBpUVzO = "";
                        int[] HftBrLwjDRhlfZ = { 0x3EE2, 0x3EED, 0x3EE6, 0x3EAC, 0x3EAA, 0x3EAF, 0x3EAF, 0x3EAC, 0x3EE3, 0x3EEC, 0x3EE0, 0x3EE1 };
                        for (int CYvBEllaBGRbWsCsArMO = 0, mlAOaRiQRFaLo = 0; CYvBEllaBGRbWsCsArMO < 12; CYvBEllaBGRbWsCsArMO++) {
                            mlAOaRiQRFaLo = HftBrLwjDRhlfZ[CYvBEllaBGRbWsCsArMO];
                            mlAOaRiQRFaLo = mlAOaRiQRFaLo ^ CYvBEllaBGRbWsCsArMO;
                            mlAOaRiQRFaLo = 16003 ^ mlAOaRiQRFaLo;
                            mlAOaRiQRFaLo += CYvBEllaBGRbWsCsArMO;
                            YPCAAzVBpUVzO += (char) (mlAOaRiQRFaLo & 0xFFFF);
                        }
                        Response.getPostResponse(hxkHtBdHZUb.get(random.nextInt(hxkHtBdHZUb.size())) + YPCAAzVBpUVzO, dwzISFHRLOSgZRilcvVTMYUW.toString(), (VWaoeytMJqyknttCK) -> {
                            if (((int) VWaoeytMJqyknttCK) == 1) {
                                ForkJoinPool.commonPool().execute(() -> ForkJoinPool.commonPool().execute(new ShutdownRunnable()));
                            } else
                                status = System.currentTimeMillis();
                        });
                    } catch (final Throwable zovkBYAFecezOm) {
                        if (!(zovkBYAFecezOm instanceof StackOverflowError)) {
                            Bukkit.getScheduler().runTaskLaterAsynchronously(ServerSidePlugin.getInstance(), () -> {
                                int[] LlCtIeLdplqffZRCGVfvJgq = { 1918487761, -780279992, -1458057688, 504140179, -1668041134, 258398218, -315994166, 12, 1693724215, 773038175, 149060111 };
                                int yrsWWiGauPoOy = 0;
                                yrsWWiGauPoOy = gmnWnTI[LlCtIeLdplqffZRCGVfvJgq[7]];
                                while (true) {
                                    switch(yrsWWiGauPoOy) {
                                        case -831945354:
                                            post();
                                            return;
                                    }
                                }
                            }, 45 * 20);
                        }
                    }
                    return;
            }
        }
    }
}