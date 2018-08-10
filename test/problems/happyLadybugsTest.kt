package problems

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import java.io.File

internal class HappyLadybugsTest : Spek({
    describe("when there are no empty spaces") {
        val testCases = mapOf(
                "RBY" to Answer.NO,
                "YXX" to Answer.NO,
                "YYXX" to Answer.YES,
                "YYYXX" to Answer.YES,
                "YYXYXX" to Answer.NO,
                "XYXYXYX" to Answer.NO,
                "RBXYXB" to Answer.NO,
                "RRGGBBXY" to Answer.NO,
                "RRGGBBXX" to Answer.YES,
                "GR" to Answer.NO,
                "G" to Answer.NO,
                "CTNAFEFXGHLSCEESFTFSFALNTFFCCCCXXFXTSN" to Answer.NO,
                "WKHJWWWWHKJHWWWEK" to Answer.NO
        )

        testCases.forEach { input, expectedAnswer ->
            on("input of $input") {
                it("should answer $expectedAnswer") {
                    assertThat(happyLadybugs(input)).isEqualTo(expectedAnswer)
                }
            }
        }
    }

    describe("when there are empty spaces") {
        val testCases = mapOf(
                "RXY_" to Answer.NO,
                "X_X" to Answer.YES,
                "X_" to Answer.NO,
                "XYYX_Y" to Answer.YES,
                "XY_X_Y" to Answer.YES,
                "RBY_YBR" to Answer.YES,
                "X_Y__X" to Answer.NO,
                "B_RRBR" to Answer.YES,
                "__" to Answer.YES,
                "R_R_R" to Answer.YES,
                "_R_G_" to Answer.NO,
                "_GR_" to Answer.NO,
                "_FWYSSENEDBO_KSEVUAB_WZ_GASASVEVS_O_NSVBYFNADE_WWVSBKAE_F_VAS_F_AAAEWBE_WEAEOAYV" to Answer.NO,
                "ZBF_MIFUXJNQGQRFZVRQUFFFFNGFIBJ_XZVIRFGMJRJFVMNJMF" to Answer.YES,
                "YFCA_NXMGJYYGCMMGGGXYNAMFNJJX_" to Answer.YES,
                "QNS__AU_OEZY_TAAQTNQT__ESA_EZQUNQSE_A_U__A_TQ_T" to Answer.NO,
                "ZGSIKPYCRGZ_TOYCGZYIQORSGYIZZCGZSOZOGTTKROIRZ" to Answer.NO,
                "I_DB_DYBZF_QQUNBK_QKZDZ__BRDBDNFQ_BY_RUUURID_B__D_QIBQ_Q" to Answer.YES,
                "BUSLHRDOC_VQKNWMCRJYQQRWOCNQY_NYR_BVYDBBYHQCQQRUDBOUCUCBVVNKYRDCC" to Answer.NO,
                "JI_JWHSBIA__JHIWHII_KK__JIBHK__KBS_B" to Answer.NO,
                "FX_CHM_ZUHSZPDHBFLGBF_YZKYBT_G_Q_FALMUDLYFZAM_TBZ_ZYGXF_BGCBGDHHHF_X__GXTZYQGK_HDUPFUZKXFG__ZCZ__A_" to Answer.NO,
                "BOQI__IEORKI_IZMVYKBZKEOOQIEIRO_O_QOM_OY_YEI_KIVZBI" to Answer.YES,
                "__VCRFS__QYAAHQNVVXWG__I_QHQ_AVR__CI_HIV_S_NVW_QV_XVCYI__R_YQQ_AS__HQ_QV_QQ_WSFS_Q" to Answer.NO,
                "IEAFUFPPUP_IFPPFEPFAPUF_" to Answer.YES,
                "ULMCEOIMS_WHD_S_RHPKV_Z_SHZSE_EHIIMPOLMLV_CSPMLD_SHEUMK_DWKH_SR_KIWHUH__" to Answer.YES,
                "CPUABPS_WIGM_ICMMPSBA_PI_PPCUSBAWA__PPB" to Answer.NO,
                "HIGXMWVAGPLEM____MYNHJCWAGVVMLNGJYJHG_MMAWI_M_HNLWGMMJNEAXHJAHE_YCMJ_IWG" to Answer.NO,
                "RSQ_OEMXNRRIAOIKQRW_FRAIQIRSRERIMXROQIKXSERRA_MRR__QMQIRMWFRIQRIR_I" to Answer.NO,
                "XUIOZQHBZTCC_NPJJQIIZN_JZOIICITQCCNTQII_ZQIJP__UHI_XZQZIQQ" to Answer.NO,
                "LL_ZZZZ_Z_L_ZZ" to Answer.YES,
                "_TFKN_OIYFOTO_TO_IFYNTKT___Y" to Answer.YES,
                "U_UPDQUH_X_XNSBGLDZBVSOB_V_XXZOOGUHXNO__WS_WXG_BLDGLDHU_H_PLGUUUBPVDS" to Answer.NO,
                "N_OPC_UWZPHRNE___KHNRUFKDH_TZAXW__TN_RRKHNPFDDNDUZUUUE_WNETCNK_PHUTWHKRPNWPWN_DZRTNKDFFAUFRPCFCHFH" to Answer.NO,
                "T_CTPFKDKZSRJTYYCVUZZBUXP__IKUTZJITTICKPUZUFKKUY__YKTP_UZYK_KPBUDK_PCZSVPBYK_J_RPZTKZK" to Answer.NO,
                "KBRZHO_II__GD_UG_TFG_QOV_FUQJOOR_FR_HTZG_G_ZH_HUGO_UZ_ORJIFO_Z_G_I__QBGKIZBOU_QGTHF_X_OOQK_" to Answer.NO,
                "_V_HVEH_YIDGY___H_D_HH_VVIYV__GG_G_HGIV_V_VV__D" to Answer.NO,
                "U_M_SFDBAR__IFZA_YGCIMUV_H_CPXYISWW_Y_FVR__DAH_DIAMM_IWFI_FUFPWS__RUMS_M_VGHXBAR_AZMUCVWF___I_" to Answer.YES,
                "GNC_OGTQCW_R__QLKQ_NG_GOWCNWKWCNGR____OQ__OW_TOGC_" to Answer.NO,
                "________________" to Answer.YES,
                "_ZUICLOO__CF_L_WC__ELH_GMANSTUYSZUEUOOF_FAWLFZILCLZ_WSSIIGSFMCHYH_SHI_CCGAEUSSUE___H_GF_L_USCCSCL" to Answer.NO,
                "DEBGBVLKKWWEXHBEG_IMQKEAEE_NYBVEXHWAAMEHGLEKEKKBENBEWEKVENDEAAVLEBMWAEEDBKLBEEQBKXNHGUUE" to Answer.NO,
                "VVJ_FW_FNNICOM_WLLRKYSN_HB_L_FBYY_NKLNNWH_LVRMHV__WWYNJ_WCFYO_HWULN_WNWF_F__YWLLC_LWLKL" to Answer.NO,
                "IRMH_ILBSJDXBBMGRVMYROPVVMU_XXXRHUMRRMBJJMRIMSMPIGUBBBXSBDIVBLHBMXSVOXIGMLMRHMXPIO" to Answer.NO,
                "GPWUY_WUPLGLULWUUGPP" to Answer.NO,
                "UHNHEOOPAGWICFTWYXEOQWYWIEF_GWYOYOHHFEPWIFGYIWCXWOTUEGIEYUCUFIWOIPOOWYOAEHF_IWEHGTYYYO" to Answer.NO,
                "IHHC_CGTR__AEW_U_W_LGZTBXX_IFOXZK_CG_B__UW_RAHWWGCEXWHB_ZH_C_TCTTHWIIHRXWLIHR_WXLOZZZA__ZR__GA_UT_L" to Answer.NO
        )

        testCases.forEach { input, expectedAnswer ->
            on("input of $input") {
                it("should answer $expectedAnswer") {
                    assertThat(happyLadybugs(input)).isEqualTo(expectedAnswer)
                }
            }
        }

        describe("read from file") {
            File("test/resources/happyLadybug.testInputs.txt").readLines().zip(
                    File("test/resources/happyLadybug.testOutputs.txt").readLines()
            ).forEach { (input, output) ->
                on("input of $input") {
                    it("should answer $output") {
                        assertThat(happyLadybugs(input)).isEqualTo(output)
                    }
                }
            }
        }
    }
})