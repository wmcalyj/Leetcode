package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
  
 Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters). 
  
 * 
 * @author mengchaowang
 *
 */
public class Q425Contest {
	public List<List<String>> wordSquares(String[] words) {
		int wordLength = words[0].length();
		List<Map<Character, List<String>>> maps = new ArrayList<Map<Character, List<String>>>();
		for (int i = 0; i < wordLength; i++) {
			Map<Character, List<String>> map = new HashMap<Character, List<String>>();
			for (String word : words) {
				char c = word.charAt(i);
				List<String> list = map.containsKey(c) ? map.get(c) : new ArrayList<String>();
				list.add(word);
				map.put(c, list);
			}
			maps.add(map);
		}
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> tmpResult = new ArrayList<String>();
		findSquare(result, tmpResult, words, 0, maps);
		return result;

	}

	private void findSquare(List<List<String>> result, List<String> tmpResult, String[] words, int level,
			List<Map<Character, List<String>>> maps) {
		if (level >= maps.size()) {
			result.add(tmpResult);
			return;
		}
		Map<Character, List<String>> map = maps.get(level);
		for (String s : words) {
			boolean containsAll = true;
			for (int i = 0; i < s.length(); i++) {
				if (!map.containsKey(s.charAt(i))) {
					containsAll = false;
					break;
				} else {
					if (tmpResult.size() > i) {
						if (!(tmpResult.get(i).charAt(level) == s.charAt(i))) {
							containsAll = false;
							break;
						}
					}
				}
			}
			if (containsAll) {
				List<String> newTmpResult = new ArrayList<String>();
				newTmpResult.addAll(tmpResult);
				newTmpResult.add(s);
				findSquare(result, newTmpResult, words, level + 1, maps);
			}
		}
	}

	public static void main(String[] args) {
		Q425Contest q = new Q425Contest();
		String[] str = { "ldqv", "tibp", "koey", "dsdh", "wxjz", "glam", "eyyy", "ymeo", "yjjp", "qqjq", "qsra", "eldf",
				"fcgc", "fuqs", "awgs", "wcjp", "pafp", "amlz", "uzql", "rtre", "sxur", "frvx", "lvwn", "zbfv", "ekfe",
				"ugac", "mqel", "ryzg", "uxfb", "urea", "vdir", "xxeg", "ipuq", "vuxx", "nzou", "bsid", "aows", "schd",
				"bkto", "jrpm", "cctl", "koiu", "vzaf", "viuc", "gnwm", "sdvg", "gvyu", "bqkl", "mtvj", "wwpp", "cyhe",
				"hqpi", "enoq", "puhc", "aknu", "vwbg", "bafk", "bnhg", "gcny", "xdap", "zmgr", "pdpj", "kpef", "trms",
				"miwe", "bakx", "vpbr", "naiw", "xlzj", "bocb", "tyyk", "osqw", "hhia", "scer", "igjz", "tvsy", "oron",
				"tlqz", "leyz", "mgwb", "ebbo", "vmwm", "nuxb", "gunb", "tjuj", "oezm", "spro", "bjzo", "jnjx", "ucbu",
				"yfpw", "fmhl", "xkfp", "bnij", "ihwn", "fvci", "isxg", "svim", "msyg", "sjfs", "rczg", "vioc", "ywrg",
				"ebkr", "noiu", "hkhc", "udtr", "kxdf", "qxgk", "jziu", "hjwb", "oulh", "kidq", "mzks", "rekt", "pnye",
				"bhup", "vwwv", "bxop", "hyvv", "aoae", "ephf", "fixl", "jpjq", "wzmb", "ygzw", "hyva", "cjgu", "ojxa",
				"ovaw", "jznc", "duct", "aotz", "ryor", "rchy", "wktq", "mwtt", "ougt", "lkks", "zraz", "jghv", "oecr",
				"icej", "szfa", "cilr", "rhej", "rgwm", "mzws", "lymr", "htch", "abva", "vfhw", "lgbz", "igud", "warz",
				"grti", "xycf", "ffel", "kqqs", "pmyx", "hxub", "vdma", "tdph", "fxfw", "drpf", "yial", "vgwr", "uary",
				"rdgu", "kyoj", "ygfg", "yvet", "muzi", "vydu", "sabk", "cylc", "eiys", "ozfz", "sdrq", "xwnf", "laqb",
				"apfd", "tqci", "gpvm", "qxbn", "ednm", "qara", "iawb", "lzvs", "spvv", "hdbq", "mrgu", "mkfy", "hxdt",
				"qczg", "nxwy", "uzlm", "jfde", "nwao", "satz", "ruoz", "sruw", "iwnk", "dclt", "smss", "lhto", "hihh",
				"zrsq", "xjfe", "jxkf", "wgpb", "ptfl", "hnjz", "yxjq", "yqyk", "xeib", "mjpo", "blhi", "xksx", "smju",
				"xazs", "zujb", "xrmt", "nrgs", "zimw", "dove", "rzjk", "rhbl", "doaz", "pdnx", "tktr", "fgzd", "jdcs",
				"yuqv", "tlch", "mdak", "fybt", "ewzh", "inza", "qakq", "zkma", "rrga", "falm", "ngxs", "xbda", "xbdg",
				"nsfm", "uqvi", "exft", "eozp", "fabz", "azbc", "wmpb", "ctpn", "udhn", "yvxk", "pqxr", "zcde", "zbsh",
				"vgzv", "qdot", "ozeu", "jcdn", "uvri", "maib", "kxml", "nytx", "vwac", "pzhx", "poqa", "vjeq", "grph",
				"skqt", "eyak", "yqle", "yhpe", "urmq", "wmnj", "eupp", "juav", "lzab", "vpga", "jmho", "icpv", "hgak",
				"oqzp", "jhce", "trkw", "foog", "bnvj", "teri", "sevi", "pgaf", "hugy", "llpn", "xrcz", "fjya", "ydjh",
				"ckzr", "xhcn", "eeyw", "ckzx", "ietb", "gtah", "wnut", "knzc", "ahvp", "aqbh", "dxmf", "eeyc", "wzwi",
				"uakc", "yeap", "exyh", "kanw", "ygum", "ytfn", "hhak", "wbrl", "bvcb", "ogzh", "ufax", "cvxp", "jpkc",
				"bhff", "mgws", "ybiz", "daph", "abhn", "bvjf", "xtma", "ukuw", "dapu", "qigj", "blmj", "loic", "mnaw",
				"qlyv", "ycsz", "fkua", "dhzg", "ctwf", "ejui", "ayrt", "wxiy", "zsng", "vjpq", "gvjc", "epyg", "xnmk",
				"rwaa", "gjzb", "jhqd", "yurf", "lwek", "xnme", "xyur", "ufsd", "bmhc", "wwwc", "atjg", "voos", "ofjq",
				"owhc", "oklh", "dejn", "lzdb", "szla", "mrxq", "hssr", "oicv", "cads", "oafg", "uvvk", "yonk", "xohx",
				"voic", "wekh", "yygg", "odtz", "criz", "qcps", "vxfg", "thjz", "gbgx", "gkcq", "bgjz", "yxfy", "yggl",
				"lclm", "rqbb", "kftb", "wekb", "xzir", "kmqv", "fpwy", "kipl", "fvgt", "kmqh", "ovnm", "rfiq", "vhjo",
				"hvcg", "wpwf", "rgvt", "tkyl", "zyyz", "exkq", "dynw", "uvug", "unqa", "rjqm", "nfsi", "rogj", "fqvr",
				"zxtj", "eamr", "oxap", "tmoh", "qels", "ntic", "zmsu", "htzi", "lxbe", "cemy", "sxae", "qppg", "vndx",
				"tbbc", "jtjn", "zezb", "fctj", "irud", "vgkh", "zsad", "aeqn", "pxsa", "mywd", "lktx", "lyzn", "uhqh",
				"qheo", "qylj", "twxv", "kffg", "wrio", "nebh", "tsga", "omfr", "kkep", "qgqe", "bppz", "ojrx", "ilqs",
				"fgcb", "sayj", "spga", "qbtt", "jnzf", "uuxa", "bsfw", "djwd", "jygn", "tzwv", "dmco", "hofl", "lrqy",
				"thty", "xibo", "mgek", "aexq", "wgxs", "eega", "swcp", "rvxo", "essd", "opxr", "foph", "yqqb", "uqxh",
				"tmtn", "syac", "rvxj", "ycex", "xwpi", "lbih", "jqwg", "cfmy", "erbk", "ycku", "fiej", "oghu", "erbo",
				"uyug", "nmif", "denc", "toik", "owdd", "hbxf", "fhkh", "jksd", "dnbn", "ujem", "rlwc", "oojq", "vzqc",
				"vsxh", "wrzv", "xmlu", "qeiw", "vebr", "jgrz", "bgdg", "bjqc", "xnuk", "kwti", "aiwc", "evnv", "gttd",
				"ntma", "ffdo", "ublq", "fjzw", "cgya", "jukv", "hwvx", "rblz", "uyvg", "gkil", "ukoe", "ainn", "lekg",
				"jwcc", "xndl", "tnvd", "sskz", "ibka", "hkvn", "jdno", "yvir", "kwvu", "npzu", "zwpe", "mguj", "gxsl",
				"awfx", "rlbe", "dlxw", "ehvp", "gpuu", "leud", "dqet", "tqkg", "pwwe", "lyqz", "hcay", "graj", "jaqb",
				"raxj", "snfq", "rpij", "vffm", "fnlo", "ymki", "etik", "sipm", "lkoi", "tcnq", "oxpd", "kvac", "yaxe",
				"xmvv", "izxo", "foss", "yzgd", "dgub", "gnhj", "nqpg", "htai", "zbny", "rlld", "kmom", "uyoy", "joyw",
				"mvcd", "fcmm", "gagc", "qrdf", "vprp", "gkur", "joyd", "rvyz", "ywip", "tihz", "udbx", "hfhs", "jxdo",
				"vhtq", "jmri", "snpv", "fvmi", "yumq", "mqhb", "rccb", "ixud", "zhxb", "bzoz", "pkpb", "opag", "axzf",
				"nlkk", "ilmm", "xqyu", "xgvz", "zxim", "sjvz", "wjsj", "khew", "oxjb", "giri", "tavh", "xffa", "aasl",
				"zngx", "ygoi", "mvor", "zdwq", "yhwn", "vxys", "jbud", "jxgu", "kpkz", "tmnk", "xjxg", "nqbg", "zfwt",
				"zpee", "coqp", "iyrz", "zklv", "dgvg", "fbqo", "vpkz", "aijr", "yeog", "iyru", "xemr", "qqft", "jtkj",
				"omwr", "vfbz", "yizn", "qqfs", "dcip", "whog", "noeg", "gwii", "wkje", "hhbz", "exrl", "cmyx", "bulm",
				"gjqy", "uahk", "davi", "okjn", "jhvc", "gwwp", "rvdu", "eeqd", "rsje", "vlco", "lhqj", "bjdq", "hnou",
				"pqdf", "jzbv", "iobg", "eyqb", "hoam", "rzzy", "ctrc", "hoab", "yidi", "ypup", "mpqj", "cjrf", "kzib",
				"xhvp", "gimw", "zsig", "nlpm", "mdxk", "jftn", "fkpj", "eajd", "pxbh", "lyks", "zopy", "apcl", "kxoo",
				"ecpu", "uzuc", "jouj", "kxog", "cfdn", "aktr", "udfu", "lgvc", "oiny", "uwci", "fefg", "oago", "btdy",
				"ofvg", "vzla", "fedn", "cpts", "ewfy", "thkl", "dfwm", "xxgb", "zqle", "ungi", "ngmr", "ooip", "fxdp",
				"eviy", "shjs", "cuqu", "ygan", "qwvi", "pwru", "xnyc", "wpvw", "ojhz", "okqg", "nolf", "kwht", "osdv",
				"kfwp", "mmvr", "skzx", "mwda", "dghb", "bvvh", "qlcu", "adbc", "hesk", "rypw", "dezb", "jjqd", "irbf",
				"wqqi", "tlwz", "nwfx", "ntuq", "wqqu", "zkvu", "hdlw", "hzfx", "czvw", "uqli", "alum", "zqgp", "cbbk",
				"lfeh", "wagb", "vrpl", "snny", "gfzg", "chps", "edyc", "mzle", "mpcg", "qous", "upyn", "natl", "ftco",
				"ukmc", "kbtf", "upye", "fgbf", "frcm", "ytdu", "srlb", "ycqu", "pfbs", "gamy", "ditz", "bceh", "nedl",
				"bmpc", "xxab", "uquk", "gmvi", "gamn", "qtgn", "imln", "bvox", "uela", "xzza", "ydsw", "fqbu", "zgoi",
				"pfcu", "pdil", "kuln", "aeyy", "oade", "wlco", "euwh", "dhsq", "htii", "blys", "jtzg", "yrvb", "lcef",
				"qrlq", "dzcz", "kbxs", "urbt", "xgqq", "xasg", "ucsu", "hhqa", "txzd", "ozgk", "mook", "rohf", "hojd",
				"fema", "gsfj", "edby", "lvdg", "czxq", "bbyl", "yiwb", "rkie", "vedk", "pueg", "yksc", "lvdm", "ghsi",
				"lswv", "ttjt", "rdaf", "uezp", "ndbp", "lsbr", "phel", "anwe", "mjcz", "ngfs", "mkei", "tixh", "oyvx",
				"lxyx", "xftd", "aeol", "iwaj", "nnlg", "trgg", "gefc", "bgln", "nmnr", "cmal", "rqic", "nnlp", "rqif",
				"slkq", "ylzq", "mazo", "wepn", "hqnd", "hkmx", "onxu", "zukm", "yrcp", "qerl", "dowl", "ehsu", "efyv",
				"fzpi", "mfny", "vtfv", "hzbw", "zlvt", "gjmv", "smbe", "wwhz", "qzrz", "ugml", "rowz", "pylj", "nsji",
				"imij", "cjat", "sojk", "lzcy", "jzcq", "rowk", "bcsz", "ecqy", "witq", "kjxi", "eeih", "ymha", "mzon",
				"yjtl", "vwws", "kcwe", "rvrf", "pmph", "uzvk", "pxho", "uszb", "csox", "byor", "ovge", "zotp", "mebc",
				"iisf", "xjkm", "zarv", "nkfx", "flih", "jxbc", "wisy", "zptw", "gtqn", "orxa", "wnum", "ttlg", "qsgz",
				"cafz", "eusu", "cqqh", "dmun", "tnhw", "royc", "tftk", "yagc", "sftr", "usfr", "wcid", "teza", "isdg",
				"ckog", "dysy", "rjbi", "ltlm", "mlol", "yzsg", "ptkt", "doyr", "rbri", "okva", "skiu", "iwfr", "ebfv",
				"tojg", "uvmr", "pzbe", "wnij", "iezr", "sdcg", "kpan", "mfec", "cmfx", "bfen", "ulai", "exrm", "jaxf",
				"vfdr", "nxvk", "iodt", "vcdd", "epbo", "tbie", "mnuw", "qjay", "edop", "ioav", "ohkj", "ucmh", "vqss",
				"oavy", "eeak", "egwg", "sljt", "xnam", "ffab", "puse", "znoq", "pmhf", "bjrl", "syxs" };
		List<List<String>> res = q.wordSquares(str);

		for (List<String> s : res) {
			System.out.print("[");
			for (String word : s) {
				System.out.print(word + ", ");
			}
			System.out.println("]");
		}
	}
}
