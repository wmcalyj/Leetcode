package com.leetcode.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *


 Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

 Note:
 Input contains only lowercase English letters.
 Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 Input length is less than 50,000.
 Example 1:
 Input: "owoztneoer"

 Output: "012"
 Example 2:
 Input: "fviefuro"

 Output: "45"


 * @author mengchaowang
 *
 */
public class Q423Contest {

  public String originalDigits(String s) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int count = map.containsKey(c) ? map.get(c) : 0;
      count++;
      map.put(c, count);
    }
    int[] buckets = new int[10];
    StringBuilder res = new StringBuilder();
    while (!map.isEmpty()) {
      while (map.containsKey('z')) {
        processZero(map);
        buckets[0]++;
      }
      while (map.containsKey('w')) {
        processTwo(map);
        buckets[2]++;
      }
      while (map.containsKey('u')) {
        processFour(map);
        buckets[4]++;
      }
      while (map.containsKey('x')) {
        processSix(map);
        buckets[6]++;
      }
      while (map.containsKey('g')) {
        processEight(map);
        buckets[8]++;
      }
      while (map.containsKey('o') && map.containsKey('n') && map.containsKey('e')) {
        processOne(map);
        buckets[1]++;
      }
      while (map.containsKey('t') && map.containsKey('h') && map.containsKey('r') && map
          .containsKey('e')
          && map.get('e') >= 2) {
        processThree(map);
        buckets[3]++;
      }

      while (map.containsKey('f') && map.containsKey('i') && map.containsKey('v') && map
          .containsKey('e')) {
        processFive(map);
        buckets[5]++;
      }

      while (map.containsKey('s') && map.containsKey('v') && map.containsKey('e')
          && map.get('e') >= 2
          && map.containsKey('n')) {
        processSeven(map);
        buckets[7]++;
      }

      while (map.containsKey('i') && map.containsKey('n') && map.get('n') >= 2 && map
          .containsKey('e')) {
        processNine(map);
        buckets[9]++;
      }
    }
    for (int i = 0; i < 10; i++) {
      int count = buckets[i];
      for (int j = 0; j < count; j++) {
        res.append(i);
      }
    }

    return res.toString();
  }

  private void processNine(Map<Character, Integer> map) {
    int n = map.get('n');
    if (n == 2) {
      map.remove('n');
    } else {
      map.put('n', n - 2);
    }
    int i = map.get('i');
    if (i == 1) {
      map.remove('i');
    } else {
      map.put('i', i - 1);
    }
    int e = map.get('e');
    if (e == 1) {
      map.remove('e');
    } else {
      map.put('e', e - 1);
    }

  }

  private void processEight(Map<Character, Integer> map) {

    int e = map.get('e');
    if (e == 1) {
      map.remove('e');
    } else {
      map.put('e', e - 1);
    }
    int i = map.get('i');
    if (i == 1) {
      map.remove('i');
    } else {
      map.put('i', i - 1);
    }
    int g = map.get('g');
    if (g == 1) {
      map.remove('g');
    } else {
      map.put('g', g - 1);
    }
    int h = map.get('h');
    if (h == 1) {
      map.remove('h');
    } else {
      map.put('h', h - 1);
    }
    int t = map.get('t');
    if (t == 1) {
      map.remove('t');
    } else {
      map.put('t', t - 1);
    }

  }

  private int processSeven(Map<Character, Integer> map) {

    int s = map.get('s');
    if (s == 1) {
      map.remove('s');
    } else {
      map.put('s', s - 1);
    }
    int e = map.get('e');
    if (e == 2) {
      map.remove('e');
    } else {
      map.put('e', e - 2);
    }
    int v = map.get('v');
    if (v == 1) {
      map.remove('v');
    } else {
      map.put('v', v - 1);
    }

    int n = map.get('n');
    if (n == 1) {
      map.remove('n');
    } else {
      map.put('n', n - 1);
    }
    return 7;

  }

  private void processSix(Map<Character, Integer> map) {
    int s = map.get('s');
    if (s == 1) {
      map.remove('s');
    } else {
      map.put('s', s - 1);
    }
    int i = map.get('i');
    if (i == 1) {
      map.remove('i');
    } else {
      map.put('i', i - 1);
    }
    int x = map.get('x');
    if (x == 1) {
      map.remove('x');
    } else {
      map.put('x', x - 1);
    }

  }

  private void processFive(Map<Character, Integer> map) {
    int f = map.get('f');
    if (f == 1) {
      map.remove('f');
    } else {
      map.put('f', f - 1);
    }
    int i = map.get('i');
    if (i == 1) {
      map.remove('i');
    } else {
      map.put('i', i - 1);
    }
    int v = map.get('v');
    if (v == 1) {
      map.remove('v');
    } else {
      map.put('v', v - 1);
    }
    int e = map.get('e');
    if (e == 1) {
      map.remove('e');
    } else {
      map.put('e', e - 1);
    }

  }

  private void processFour(Map<Character, Integer> map) {
    int f = map.get('f');
    if (f == 1) {
      map.remove('f');
    } else {
      map.put('f', f - 1);
    }
    int o = map.get('o');
    if (o == 1) {
      map.remove('o');
    } else {
      map.put('o', o - 1);
    }
    int u = map.get('u');
    if (u == 1) {
      map.remove('u');
    } else {
      map.put('u', u - 1);
    }
    int r = map.get('r');
    if (r == 1) {
      map.remove('r');
    } else {
      map.put('r', r - 1);
    }

  }

  private void processThree(Map<Character, Integer> map) {

    int r = map.get('r');
    if (r == 1) {
      map.remove('r');
    } else {
      map.put('r', r - 1);
    }
    int e = map.get('e');
    if (e == 2) {
      map.remove('e');
    } else {
      map.put('e', e - 2);
    }

    int t = map.get('t');
    if (t == 1) {
      map.remove('t');
    } else {
      map.put('t', t - 1);
    }

    int h = map.get('h');
    if (h == 1) {
      map.remove('h');
    } else {
      map.put('h', h - 1);
    }

  }

  private void processTwo(Map<Character, Integer> map) {
    int t = map.get('t');
    if (t == 1) {
      map.remove('t');
    } else {
      map.put('t', t - 1);
    }
    int w = map.get('w');
    if (w == 1) {
      map.remove('w');
    } else {
      map.put('w', w - 1);
    }
    int o = map.get('o');
    if (o == 1) {
      map.remove('o');
    } else {
      map.put('o', o - 1);
    }

  }

  private void processOne(Map<Character, Integer> map) {
    int o = map.get('o');
    if (o == 1) {
      map.remove('o');
    } else {
      map.put('o', o - 1);
    }
    int n = map.get('n');
    if (n == 1) {
      map.remove('n');
    } else {
      map.put('n', n - 1);
    }
    int e = map.get('e');
    if (e == 1) {
      map.remove('e');
    } else {
      map.put('e', e - 1);
    }

  }

  private void processZero(Map<Character, Integer> map) {
    int z = map.get('z');
    if (z == 1) {
      map.remove('z');
    } else {
      map.put('z', z - 1);
    }
    int e = map.get('e');
    if (e == 1) {
      map.remove('e');
    } else {
      map.put('e', e - 1);
    }
    int r = map.get('r');
    if (r == 1) {
      map.remove('r');
    } else {
      map.put('r', r - 1);
    }
    int o = map.get('o');
    if (o == 1) {
      map.remove('o');
    } else {
      map.put('o', o - 1);
    }
  }

  public static void main(String[] args) {
    Q423Contest q = new Q423Contest();
    String numbers = "zeroonetwothreefourfivesixseveneightnine";
    char[] ns = numbers.toCharArray();
    Arrays.sort(ns);
    System.out.println(ns);
    String[] s = {"owoztneoer", "fviefuro",
        "ertfsxvxttiorseenivsoiwosefeinoinwoioousiieihtfirrnioeenwiortwsefwnnniseoisontieiitnvsovthrenwfitfenoiwouwtrtnxneisieinovhuieenrveenoiuoireooieiuittefotnoeeftfsetooeniuvrsnvetwieetvoneeoiieeiiirhftnrntihenseveeorioriononnuhweixefoiotowxreossentetresvzoerfeonvhfoestveooxesintstvefewrifsneeexveefoxonvueituwoieefvofwrfistixeesooxoeweteortfevtsuffohnfruiwitnuxexrevrhfenwenofnzfvsiofeneesoshoefxoefieiieeoueofoivshvtrsoneenenwiexnifttfeoooetesnouewtneisfeenwiiwnvuntnwuesniffweeoretviftseeexeoetzntefnfoxesfforvrwrrhrewtegwsnvinotonitvxeerwooeefswxxtfixenwfxioevierefevinviwvxonfitouevwxnshiewuntwunniennvunvfnnxinovfsvohrresenffintfissstnrfwinsegrrnesentoitoieneiiinuenrtssgosetoufnniuesneseonesetnstiofieeosvoowooeueietrheiienstifweeueitioretiwefwvonsernsxrtteeiisofttwnorovenoisnrsoxseoeeoeeovnoweeowhfirovesxeutisnnviieneetvuxnreoenxinfnrvxntooeonroewxeoirxenfeeehietriuoofxiexwntotointhwvtnfwtnrieeofifinevsfxioninsvntenrhwiwovfenwfrffiofeiehuriieeeswooeofienuoeifoffrfetewoofeusoeiireootseisouvoofntexsnorovrersoovnoovtvvreineerrieeooxtoeseeowixtfeoettiornofunintonsrenoooosxifsrviuitonnetosfwnewnetoznvfhueovwrnnooexnnfeieninetihvwnrexiinvnieevexnwnvtfewexftixiernoonfeinffisofoefevviownoeionforfevufoefreisetvovixxoehuiniivvirewsrsoxoiohtoovvveioertfhveoitoxoiexniieneteiwerngfiesiiifwehsifrteieiwoueenwssnrtxnoevefrtxtoesnferxveeoeifoxuivononeeentsohofwexinrweuovoutoenhnnxenveoihfstturoeeeitrwiirisiinuhrosooiinffnoriweixeiuuenxtoouwosnnshiixnnefgereothioiinrfnneioeenitofieerwtreniortiweoinniewinxeerxtneeneoofutiiirrnsvoefoetssxonfxenowirutohnxerisweewuntnwfwounnentnohevnooxwwiifsoooevtviwsfeounfeitfxostgfgtnnfsounireiiingofxwesfroeofsxefirstrfnerfonitorneneiuifvhnninfvwsiffrffowxetvnfsrwweruiirfoooeeneetuioveoiioowxwsihvowfsrefifvetnwnzfoesnnevfoitrioniehtovwhreonensnhixsifnioeuushswtnnnfnofvneeetooeenheinurowzvftsoofwwgewsunnioffwersrtttohsrfxsoooitvnnsgruieuvteznwrueiisrineoewnxooiwnrreeofnxtuieesrnvtwotfiiewtoteriifwoofieriesoteofterverrroievoitnnnoweineehiowwvsweruooioffovoonrxvsresitrsnfinnostheeffosieeewntewotwfehonvfonrwrennwxeouontwxroitefnveneessrneeiiioeufeevofnxiifxwhefevxxtiosieonoexfrnvtfntnonereioiiferoutwtweouxoeneiirwotenrexvoouiooztnnvreotweeetveefwzeiueseiittitivsenrfseeisieosinnsreifeewnffiiffisfoiwfirtevewwuforiroteiefetiexwioenshneiiooesirhnonnnoriieoioruevroesntoffnuvievtinierfroxveriutofiovweivnifuwrwniteneefoeirxtnfiovogvfoinnrnnitviwiointtwneitnhetihuetnogwvfvevtxwefooiihevxnvxefftnnihfrrieoeortsseeoetnoioeiisowixnfowioseffexvoiwtteouieoexrfeeefeioxotniintoxwtfnofvxoenneoxowwoviionefnnssoifeoxrssovteeietoiirfeeretnerhoegoiesfvenwnnovzonifetorititohrtoixsinvieivfeivueufnisfoeinetioeoeonwiustxnstenwisnownornsievevtuwnontsntuonseeeneeeeheorivoeigoxtnwessuvfviniuuivoeeoetwvnxixxrnuvfweosofseohivuvvofivowiveinwvouueoeettwoxswnervtnovtfxionosweuisooiwnewwxnruowootisinrveowieoonewroefnsietfeentxoonoxvezroeutvefnueioihhxeoeeuxxifotwneeihewuefwexnftsnonofvfveoufniegionswreotrwfeowfeexxeofxtnuevieffoeeeeivteeeseofeniorevrftenrtnrnotfworsvifuesfvofxweoffvienitnonfeiotwnofnruswfonwottoenxorntfnxeoeeveotnouwetnfteuifnoxnvnnffssxfnuwiefveowexwiioffeewuwnewroiegnwzsniiinoixxeiitstsiztoeoefeesnvfniehotxouwtsrieernouwueuovfwreernovniwofrsvenioevnwoeotnuenfxientsooneexwioueioeeneouoeouteeweiitrreuioheonteuweroewiuiooftooutfeueesfenuwvniueniniforotviewinwxnhnteeftotfnoxiruonutofvrevvsutvrtnexeovoxffoxnfeiiirevesrooueeonnwnxetfofseoioenwnoxeeiwiofxnfteottufnfowseteeeeofwnxreevnvovuurroeefefenuwtoriofxwuiestonhreeuieeoonirefieeostieeeeossnveueerosinweefrsihrnveuiwnesoeetwvietoretzxonnuseixhsrtgnofnietseoenwvonnoieftvoefotwrooetxetueinruizotwuooiooveonoiftuevvenhroerenrfhfsfifwreoewwrtsesoewtvtfueiszviewieourioeinurnsrethertivnsenswenffhnrsvosuftffetwfoenneseffrenfnewsneneeisfwfoettfsstnnweteffotnfitsriotoswsuiioeenternsvfxivtiiwtnfosrwwretsfitsoioohfveosfovtifneeieuivtnexfuoeeiewirioruzonrenvitrsovoovvterswfweiiioorewhsefrieinerenexsirivifrxrsnsexoosveexvotoiofitiexfoioiveteitroizeisiehoeeoniuiewooeisuifxtotitehoswvtfntiiwseouxnhvfnteiwvrooioisnhesowreosiswenrnseeiweisieiewfsxfoxtreeinxxixueuunhwoetosxnvrfeeewhtxeuufiowifefnnneesonfxitveeeooiivetnovtiwtneoortoioeuroosfxfewnxeeinnetnnrfwrfhvnieniwtivxteussoieeotetuooxnuseioiwxsorroeuenrentnsnvosrufioeonteofiniiexfuisseooeiownsnvutwsrfeeieeseiiwvfxrivnfhhteftuvfuexifweentfoovsooveruutoinsofeswuxofiowififnsennsrixveovowfeeueevtinvifrooftirofwvuoutnuxwifweteoiosieeusesoiirneuiusnnxiiwxontverxferuefxsnnorrenrzeruxxnsvooetfxiiseirrneetnnniioovnxieesweewfieeuftzoovnoifofwheexofxsurweesinweooxnnoeeownieiisoowteiofonewxwreoeevrswretotvnewetvxtutufeoeoieeuhnoiieuiheweiteeniftxerntsenoxrittievosineuuxesrwfeneeineruxiosiveeeenftenvinivveroxhtetfwnttgftvninhnonesteoexnoooriowoisenoofowwrtwowffttfrrtervfvufeotffhnxfeueftwwfotrifwenfrfetennisftefeiewvnniiowveooiirorwivvxftieoweeufotorsnrorveiftsirvofoontixfnooteoneeiorneosurnhnxfioiiteoieineeerwftxviiwnteotefesutreeenenvutxieiohvhzrironixovonrsiiteefeeeiiotwfrnhutouitfreiresefeofofiniifnennowoifuevteoioiixtnweeveroeeunetoeeeteesewewfxunioeufoefroreofwnrznvifewoeeouxxetoirnoinnsttwiiigrnoufrerhovfiveefreteoswsfvsrseietneewtwsionisxotortnsvfsvfriioisnfuuvifiwssfofnxienxftisxeheoffesveioiitnseowfoeniofeetfesninfvusiootetixfwewwvvxniurefwioheriiooiwfvsoveifenetroeosonhfvfwooeononfghuonesefoofnfstxeevoenieeuofuvonniueoooinizxfieexutwxvnosroorfovtoruoetenrsfexnweiinxotfnvfieiiinixitvwwweoevnhveftrrorseeeetouefiuxoewtxnuotvoieesivefrvivfweeihwwxiexnwotffnxiwerxtwnwiixufeoeenrieeoeouseftifxensioiiegornezonxenuxwotvrsiivsowffnwoinhfooxriuninioownftoewvsoeteuefxorexfeevnfinnineitwtiietiufitntoowiutthrtoiefsewsuonvveetefoeixiexovriiitnfrfeuntwwnsgiuworuosvenoniswitrernnerfvoftihonhoxwfosevirfnwftseghxrsitiirvfvvefhvvufiooerowtunewthfvfeoeoiwouvefffiftietvnsoinforoegsrsexiowefoeoufeofiinoiioifgvoiteieorenevieteeitwuuienoioxvriowoewioenrrxooseexiuzeewoeirwotozetvoreortxefuvewofeftnueisoneeivroniewuwniveheoohsinonnfnvofovxetveiifniuiwvwfieoseseisveitsghtteeeiottsivovonveinvwtteofifevwnexieevfvvefhniwiueurieefeifoevnnexwivieewnoeerinewoeefofeoohnteneeenofoewvifvixnoetvtitoiwovsifxeeueoexeeiwioeeeonxnotriveionseioxvewnfvxfsrnstwwvivvehvnesevereivfftonrvoviosethueevhientinxvefiintvisoiefeiteexfsuonotieniievereeinexrvstnoosnrwhexoffrweuehonuetoutrsxisthrrfwixueeuurvnseiefeifrtenivtonovrontesnrouenweiisreetunwonvethifewesegiifwnevfotihwinenffnxtnirgownxhifiiwfeewfienrviixnitoufeoiiwioueovueungvoxeienuffifroxfifninoxetteetioxwoxexwfevswtvonrtrsentierusuuitiotevnonootriioivoonwvxiewivwotetuevnefentxfivwxxrwivrwevuheueeuohsfesxnivonwnsonriteirwehfehtrhunioofverwssuvstssenxifneriienneretevowererfnifnnriewfwsiriffseuvvvforisxvosntetrixofffewiiuurnerninurfhsfvxonforeexoeirxtneeifvootxnioewfettfeiseninwuxtutsnrfeonewioioiufutvviweuoennowfvtieiuuunnitttxoinitnwtoiiiifxnftenoioterfofofnhofxitvvisvuinnuveeefrowhioouioisxoenevthuinfeifixesrherienftfsiuvereuooetofsiofeuhxvnhsrirtvuwxtrnisstxtnoioewixfieootovefintegtieioeftifrnnextgeeirnfhoiznesxefrvvinnosetoiftennoonnxenwwhtiuwshoxirfefeeeeneoivoifnfvwsneeotnueuusohxwvnnweosinefefeoeoeeoovnwifeunfwfooosoostiroertosfvtetxixffertxvnrnxetfnunehwsxtirnueviowuffrureufuieiiefweneritrufxxnronresussnueiwetxxiofxntvrtxinfuuesroivnntiieosoffiroohtetoroeotfirfvnhoffieuonexewsxnssrvottexiifweohfeeevtfewonotnhixeiintetzrtweeeevenwunoonfefnontnsvviunxvritfohtenuuvoioouroeieovnesoeotnsevffvueuonwneeeoutioeieeoeeitwieuiteoesesheinvouffrerinnnoonesiwreoietfxeirforotninfonnvttfnvooenessnsuhnonnoxnterifwxefrfiruwvseshrwressufifoeixtentnsneuninivnioeonwxsoofnvrenwsoifrivvewnosreweewreveetfiinhtifeoxuoienosovoffexoinwnvieeoteneosuoeeisfnoeotooeveeiitfeonifesnineeeriiiwffeovuoofrwwevioisftstwveowetwsrusefhriexnfnwewsevenneinvxoiswefesetffonioxsowwveefsneeeooerxnefxiovsvoesewiifvxeeoxxxuteofoeosinifiestoroffosswwuinroixvoeiirzeesfsfvfreffifwveiroeiisieeeifwexfewhewxuwnofftihwovevstvisnnzorefnoteneiirirfffiuonuuuveoexiiotefoneevsfonsrifueoerfonneteoostieiiitfuuoeuufveuerorxtvnnfentreoofunfieoessxosfwotonuxsfwniounwuwiwioxoierfewioirvtseutooostnifreesofinefefnnoeneesioinfhoeuieoeweueoonstutentnffoesvfoneoeixrffuivrnooeiewieenfvieeiowrroiirrseoeieiiovneoiroetetooeexovositwneuvetiotxvtentursoethwiievreeixoiieieeerwieviuefefowvewoerxeivffntriouonveoinsvotfienneietfinutoovexennvinieofxoveixvoettvxeoewsfsiisxefuegsooiniieuffoveoewfnoxefoewuisgtnessnetftifvwfeftxfwtnenzvtnrinofeteinvxuftoueisofitixrweixvviounenvsgtfnnietnufohvrfxrfesrfoixeievxtseioeieeoesseetxeioiswnuseoofsefenfeitewottoiutofssreniextevsreiesfrvwnifhfueeuitfxoneivnrvhfiwxoiiinxoneiosvwuevverehexinsnoonsreuietnoeouiiwitwfvutovitsuienriifeotirxvnieenfoftooxovorvstetfoeontexfnnnhtrvniooohtewxooruiuhsfnerexvosnnotwvvoeeowvtiiiuiviisonroxffwooetevneeeuotntofwvietotsseeusuevnosutswoeirofeietvitvfonneuouuiseriixurooforvnneeefgvurivfgxfierfwwoveoootxnefefwssvvvisoohevfnowntuniseieewunofentxieoiiseonexnxofuefeniiixttwtesioifsenevtoontreevwwrveefeeenooerensooeetovivvvineiuisfofnfrwnvfvonsefvexwvtntifueveswwfxiennrnwfegiishniinesenuweieeofonsvnesvfrwnexweetooeteuxovnrowwsenoxunfwntonithwnenfifnsrnffisnwneeirhnuvfurroewoeeeoroteoxoxifwxerrfvrnefoixeeweooiohitnnnesrnisositsesfuuisvovfretgxivvofeuefvniisveenuoreenwswtwnvewuevwurfevfennoveoixeuuuifnfronverieivsntthrorhoroxootzoonoriofisiueenoievseveffoffunvfftiwofnnessfevuerevuinenffntsooftnoieirnoioshtnnoionoewritoinfseheoweoitiesneiusrinvifnieouohexnrtsintxooninrseoexrfsniefvexoeirxorwtefoefexovewwoftetrtixfxeuwtfefsrnntoiteifiewxoioveeviftefoiirinivwnitswxifvuieonvworstofoeovoienxnwfwuesoonviuivuniwnwrrwrfiexunnerofnnxoovezvosneeeftoeowewooegoenwoevowfttniifoosneweixsoenttrtutftsreenioerroovewenfetovrrfeefwitseoeevhfifsiioeerrftxowexfrrseevtheisefonofofneifutfeseenwrsswoovetfxofvroevxnnrtviowxvtssriwinfnhoonsfsifwewornuehfnrnvsnffiohoneoufnreiertfueenifofeoxtowiiivnioreouexfhnvsiosnnsifxfoeeooofeefnneotionhieinvhhniefxtsinxeneerinterrnfnvniionsviniroheositifuisiienvisntenininxeoiifnrruineowsiveewtieieurvhuteioeinnoovreeeiexiiffieufetiiossvtnosotesxifofitevusrforunrffniintfefnwiefxwiieoufooneiiusnoiwvohoivuiufuosiennnffnztiirnxetiiiieifotviiowfiveexnoivenfnitfoinrivtvtuiffstwxvfofwfiefxfnowroofveeeftoegrwsetfixtnefoouurionitonnrvsvwouirittoeefiooietifurrnfinwfvivewxuoxxftionrnrowinuuietnenriunwfiefoutnroxtewhotinvoritnvnoeerwnffveuiorixeoefefeiiniueiowxsosexortfreevtoxnfiwvnorzsiuoiiioftevhieerxeoisneneeutfgoitwftoeiervneessoreooviuusfioonsxtroviroxoenovrnowntienooiiuitroxortsfueinuwiwfofnoevveorvweixvefnfsnronhirrfrevonevsvviioieiiviireovffeeetiutevsnowoetsfevfnuxetxtnfssswxetftueirfefnrwixixxvtoieeninxofvooiveeooxteseeveeneenexeeoxtoieinoowuofoexveeiotosexosffrnexoernuvoiniohiivinoirwntstniriieiooeeeioietrxxeshooetienxeefneotifnnevriefnnsfouvvenfeoeotisienweneexufffffwntffutnnsuennxnotinrvooisfesweeoiownvxvwroeehrirotehoveorviwenxeuexhfrxwovsivonuvifiinfweeefoonoexhnefoxserxvoxovoeeettfoinevvfesoeonffiifieneuneheeiirueowsuvtefiovinoneowxeiveieoifieoieirnrenefnetevtoteowusrweiiioisrvrewtssgoeisxwfueewneeefiseexfntnfxtiirtiweservxtsxwnixvwniruotentgtxozouooruivfniihweuireizoenssevurfiniorueneuifoeonenoooiwxxewtfeewoxifiiosoifeeunuinfxvinfuovfwiuvnxnoxsonxsrteiitnrvneewrnefsufeovorowenoouretrsgotinvveeesotoeieissnuisenffvnouovssoooitntifeiioseosrfnotnsunrxeveitviiihoivfirxroreisiwovwfsoowosuwrsssnvuoninssnxreoenetfuifnoeoozoiroxeowinieeuhvsoixostzftefwxxeuxiusowsuseoeesevefseieexnorevsniiitwoiitttixvirirorfwveovwnnttuivrivtvuovuvitnnrsrseefeewnnvoifieniusonvfosnxeivixrifttreeotefsvitoneenivisovsineototvfvfnrnivovieiixnuhteirootixousetvfvenenveoevhtoviensretiioinionifoswffnriifhixevifuennivsxeeisfnotvrofrtooerxwvheitiuoitrrnueeoereenfitsnneiugtffoeenoeswxiowfnvivfnefxwusuretvesngiuuoensruxhnvnfwietwitfixernvwfntuioiiwiftrsfoifntinotfufinwuhtefoooiitvuoivoneieowntesrfioitnwuwtoinitioeonefxufsreersonnixxenftvueoeesfiefuifxnnfverixriiorxstwstofttffonwnvnsnehfeefxtnsvootvftwixneieoiiueennofeontoefrwioefeosrwnifrtixotwerffniunxoeositeneffeevtewisisosvsenzeinovtesoxoerefssoennwiestoxfexinfftnheouxtihirexeuewoouixihwfeviffiiftietsseneweooviofonnifiohswrfoxoveesiovxxeviveoneeeoifinennvefvrfvwoxnufrfuewfruitnhsirinvffohweoeenxifxeirnoientfiuuwnitfnrfnuivvsevwneerievrtontunoneienexuwtnuuioiofttiunvxevieevierxoixosnwiofrffnsevnoiexoffsntfftnoewnsefnoieeeonxxxviuefshterenotioonfzuuristrioeniwhreevusfnnroooverneieifrvtitnnntiotuurofsfxfuerxesefrehexefniffofotnxiinexortizffwiosfusuoteusesesxvinewoeofnvseiseinnxeeofneeoeuirioiievirffiisefrftioewrutnivsoeefwexfxorhvfeensnnnxvgvsrvvxvxeeeewufuivfvsisfsveiirftxooefrfesfiifrxooerevooentrotisshnixeitftovxfveusnreietfeueieinwienuivirfwsfvneerfeioesissvvvsrtfonvnsfffiveeieonviihtgsoroewnwfohxexhnirsoowinexiiiiooieisohiunwnofennfvsswneoeeioionieoxwowitfofofriefxevnsrowieuistfnixtuxniwseiuwixotstiientfvoeorosntextonsexnsiitiffrovonionnoftevehewuirwtsfnuifiiiveoifrfoeexfsneeionnersrnioiueuoteonortiftthnoueivnrwisxuonieofervieohrfxhvnetsnnfxirernxesnotoenshofvfvoxevvouononhxroresiivreriesoeiueuffifiivtieihihurtweesfnsieffntnvvieineufnxnnoinneivseoisneifnononfteoofifsnuntwfooorrsifunoixueuenivifeofroswinhwrsrfiwswuoronnevexxvxonsvieeeteinsovtwoxieievoxfsteeeheweeensnshenvvftnoivwihnnxveeooxofierisnhnnuxeninnvoerxisersethhnztxouexutefxuxztrexrorintnivufxenwfsrxruxuxexxooneotvrsifwiuvwwnuxufefvtifsfeiitsiuxnwfietoeffernwiniteeeserswxooueonzvinefuowvneiexoestneeoigsoofwiovveoiviirwnnntoffovonieeeotwfnwvtevfevfinwworeehetfxiixtxnievoveifofnsvwooxvxerewnfeuuifiwinoouovifwvwtrfeoieiisnfvnnfsvoenenxvfftswivxowfiuherisnssrnseionsosxsfofevouneenifeefieuexfefnorrhoeetuoweveunwnevseoouevwrxnrwesnensxefeofeitfiewxveoniesiiosnwifnenesnsrnwnvfvowrxsxixfenriffoxroxrinoiweviotofiiufnwwfeotsnihexvvorinnewvoseixovnetisefrfohhveeeteoofosetteereotfwnneieeiivrfrtnihxfeeirrifuerfrusofsefesrooovritrrxxfwsevtviinfoseouofitnnewfoffowiseeitiottvegvnvvieseixoirofnerwfvoneeiiofroeronehovfrnweofworonxoexroenoeseoweoinfveeenegrsxenettxfoofieoinesftfoxnirszeoifeesoixtonntevixesevoitenfntnurvtnftiooeniueirnifftiweeienfoiixviinsuefzfwovnvwtvwfefuiefnoineeveeeiwvtoooevnisfienninoutvesfvneeisxeoeovoesfeheuriieuotugesvvninnvrusrteonifhszoofnioniefwxtioisneuzuxnfseveovvenewoevitfvnstniewtxwoefeeuoevvoiresewieivsitvixrfienooeuurwvitonretfenvowetohontnixteeufesniinseeufixxfowxxxvvvfvoeoeoertieieeeoeeftfvsoefioieirsfrseotiuexiiisefrotonoenownwufeerwheeonxwsisiienwiootiefnxtiefizuvivovereefonsenovfnofiweewoornevofieoxinnixietfuxreiinfxexevfoenvteosfrstrufvtvrvvievxiiffftoiefvhisofeonihwwftenvoieveeinftoweouefteinfeetnoffrwtiseinrnivexosunfeohotoevnoiooisegvseniivsniozieoueufroeiveoenesfsonnvnfteshnfxnionwuixooeioxiroivheiihoeeeouooixieetvvfsieeuhnegfeteeeofrifofevteeeosvoveuwietusvxtonrteiteehsnofsefetsionnfiioiiiexefiveuixiofnnsisviuxhsfxwteoftwureuninrniwexunsvivvivofeunfesxofonsxwefisxvnfnefsivoxiotsfeefiitnsefviftrtovoenifirvifoshfuxeetgreenoneoeefoxonfhofixfeiietnsstvsseenuoiweouisfftfwiiwoosreresnoneuriiunoffoftivvetiiineftznszsfisveoovinenssfeeesoseehfnfvnvnsoetvxsewerireenonwfnfftoveiesseeniztownietwtoniroosefextreifieososexxefnevivfninexeienhvehrsvnetewefowetoiinfiiuxoetfnnxirxnioesfnvieuifouwnvufiinniviwnfesnonnwwefieoxoewiuoinsreoiffsennxowovxieixiewnovfgisunfvfntrieoossonsietoeitifteovinfnveeeevoieeofeesserefoxrisfeoienitvievtifweiexitunirefurnvwnvotnfoononhxeeisehoovnieieesiwwuetufnnvefeeeoeinevefoioeitivovniriiinxosivfeftoiieofriofouoweuxiofifveeeenizeoxxveeneovwtonifeooiiirinixnifosfvioisfvthevxnnvessuzffntsiwiinftiiwoeexsrrneoxiveonxeoeeonifseesfxtsisoiiooiefoieotntenoswhfsxnssewseuftfeeifevsftvrxnosfweionxeonfoevofixesvsefoovoveenfveiwonofsetnefeenzofossronwftnefeetoetvnitrivsoinrnuwgiinssveiteseoosfnveteinieefnwttefveiewiiuenfusutfiniseiowfiiginietreusvenoewwofvwitfeefrxrtfoivioeninoooivsfetoinxfswtinoviroiixtefoextooriewoiesofesvvvesitixernofixnxteeeiehohtiivteexoosnooeninieuxeefvowenortofwefooieefexfrenisezenswivotsusfffivoneofvwninnirfiesouwrowiiftsvewwuottoenveeiriivevienfvnfnuwxenwtffstevhovitnioiirnonierivorhnfniewnnviiffixtefteenoiiosfeotfnxwrivenoinfnxnnieeffheeeweetvexnrofivxortuftfsnetxwwtfioisirinnniseeiehvofueishtwnoooftooewisesoirnusoixeinioxreseuenrsstrevvxsiwfvsvoenwveisuveeizusxftwvioiiveoerweusfehefouwvunwixieeixfwuovinvintvontvenvrueieoooxnufsxevevxrevnivnievrirnrevxewxforviitieoiiosnwfioisixuixefeersxhfvrrrioeeeoeooveuienoofisoxefrxenviorfneoivifeeostnfeeorswnxouvnevieorxwioehoifiohieftufttrxnexfitruoneheexerwrtnseuenvtesrioeveuivfseoouvevnrttetrofswxuiexnetoefionoinegeooionevrevteivevoewefxreierseevnffrfeworhooiiesxeiguwesnsoosoeeotvevreoznfhoiwxouefrthiiixiiiifiosiunrxfniexstsoeeeiofuforveitsnnxinhsoxevnvxvnxwngxneofvefrroxfvsvfnisniooxefuunisvtnuvexxssieseiiexefxuuiostfoewnnoofonovoufuwovsxovnsihiixvnieosieewistsiovwuooweesefounefruwtoifhvsestennrosruetreeftfionwtenvtfeiesfeovfeeiiivtifsufirfnwevgtreeuiixievxnonfninvoiiutteioesrtvuovvrvfsowrineoteiiisuizvtisitoivosenieeiiieoittreoowfsoeffnenxosowvrnvswnnensfexeuwwwutwuefhffxienviontiwfffneioeonsrenxixeihouisiifsowoneexrewvsfgfswfssfotinsxneienfeeinerweoetesiosofeeonoswuitfvneeisetitofiohgninvwinuhrieownveiufetxvensifvftenrieoxorfnsfoexnoesenxnotfeovxorioeouvviexnsvvvsnfiooeuoeiineosuiohxiixgteivifwihofriooeonneoeuioxftonvsrwnixftsvviinfroeirfiexeiowfineseneiowwtexoeoxsnieufneuiteifxifxieorwesznnwnfeoueiiuvexotexrnosvxinrruveeivfnieniexsnnfiexeeeresorvveoonwwissiuruxeishxveiwtonxfeivnnviffeixifowtositwwxrfieiisitewsoesoeinioihxewfiovffxsevvowifftoeieeneinttneixiioteiixeeiofiottoofeoxferneettnftesrnuievfouoruntiiernoheosroxtonfwhrhitinoowonfiresounoirwiwixttfssxwieoerertfiswsfnenvnewofeeotnuuirntvutesxtixfuonexivfrxfrutfthoiiiovunfeonsiinxieiooioeuwuoeznixvnffgeresueiereiweofusttttnxnrvnenfxzieosftoiuwesoxonnnoixsixivxvixferststiefiztitoiefsxnnetuxnnunfoeooioiooiewrtwtionntisoretrovniseonvivrofnutioewriieiefnwrsretuevogfeuiffworiioointtnsinewehfsuoesneonituinvetofineifienteivtiwereosffontstxesfitxwieirotsxrriihuiexuvuffnrovhnthsfotwxhiniiornueoritntfvexsonfusfetnuofeirfewnovwfifwsorioossezftwvfuteuieivxnenffeitreeetnvfetfrrnvoeervnvsefeofroooenovorvfoiinuinrxoeeeoisixevwxtzisewiesoeiiiuisoenexitsriosizwsiwseroiiixunfreontxeixineeffnrtiiioeonsoswuiioerruwxinevewxiiienfnifnvrxnvnnnsnvexeuoneoniunvtenxtorfeewsvnevxvoesiosuvtonvisweuotioeooeonnfvoforontnooxnxrfiuihisufnitsnffxteeeoenwwinwxettiioirevuveitfvovovnueeifxffwfieoeiisovenoieioonfinesoooeiiournfvooveethnnenvsienovvunseeitiffxsirfeonttwofeeinfnevriuvtneenneeriirhxwfnoeewvosrvssnvntiossxtvevwniwfoxsoiuefiuwieeiiirioteewegovineorvtnoinnuffrvtnntensxofvvruivrifftfieintruooioevsivrwiesoxisnrsrgosfxoenosxirnoierowiivfexxeeiseiierfiefnoefiineiveitfxwxiewvtwwueneinssvinstnvfniwxnivooeeeinvvniegvsvsioxineeeofeeneennvhitxeetioseezgnsuutoiveeitenstsnirreseroevenwissfinnnzirierrevuwerfefiiovfnniiioirirninfrnfnefnnvftvuerveooftoxniiifoieiviufrfnoxwxnornfhxeeiexenineifnnvtftsweeiuioosoioofeveexixonuifuinrowioeixeitrxxnswioeonissefnxeueinexnvesioitonevieirzvorexoeooxeisiioiieofvnxwiinexfieiifsneoifituefrixwnxoefvuiifeeffsiirfuntiiegieoisiufiwiexnnoifxfroeffoforvooivvtoeieesxttnuiwffeeexueiesotifiefvofniiueoixrnitsnefosvroxieenerowsevnwvswiexnisxnseouxtrsntrrooeeofriofofwivnseivrhvteiiooexetusrvnvtffentieenfnvxtnfofifwueffnfteeheoeiweiefuniehnneituevieiiiereowifvonuohvvrtsofeeovifoiixsefuwsesierfiensohewsfefsvinvifxfeietiwofinnoxssfofeihnifivtfniewiensenrvoreefovxeeioofewifniieovwrernontrrfrtsiotoixnvifivnrousouwsiiueitsfeihnfwrxrntsttviwxunwoexuufuoerofeerfnheenvneiitfverefiirseeostehteswufesfuetexivfeevfofieesfeineevfvnosehfoiovwnsirnerevieouxfuuniefnfhuowontninnowoernffxistrisrioeueiofevursxeewotosxfertxseoinsnnefithnenxrotevtieonnxeoissitieuoeniteefnnxenxnesnsfevefffxniteertitnoreenfzexfsxxfsivenxoeevswntxeiwvfoiheetneuohnsnoerefwexewoieneeooviiinhrfwxvoeixiinnitfowifrieetvivxtxsvfftovneooexoheeosnwroorowiisuuensrsiesnrviwiirevifeffeirnrfnniwtxioonoetfsvwuswewseiushneseionnisrvxrixtnrfuettfeitutheetfexnereiforestournefweseiuwtinfwsrotiofiennunseuuiteuuhfxosnwrwvewwserfnriifieoswihstsefvvnexnwieueesewsuooniixuootirsvusxwfeunoinxexesnnnfvvizrrwiffteoenfevetxnsegffienexsotenextiefuxienxtfsoioeuoxeehifixteftnioeintnrieeortivwfitxtieenefetxntioixegsinrosxxrnnoofeovooihterfonvusiissnuseentoeozosffueixwnhrfewiioinnorovennvhxvxsrvswntosinrfiierieneriitonxivtsevesnoroviwxitnfeniivefesietovsxuiwnnuwsfosiiufuifiiefoeetveofxnvioefrsvnnfeeeososnvxnentxrvxoithunrnrsfwtoeveeeoeexoiueiftiveifofsrriesneovntsviueztettxinoiohiinfuiewefeeeufvvweiinfeseveeiifuhhoeivisevuueoeifinhrfxerxitxfnnssuvrvfentesteuswesnsffeoinevniirtseonisvivowtfivxifiotifiiexuwirsfnvtnrfeeiiwotnuixosovoniovnvzvttseuesvvnseirsewffrofxfeetsotvwoefneinsosoifiixeniowtrnnxeewfefvefoohxewfeuxxnsveewievozseoofhtonfnniiutvzxsxnroeofexovewxxfsetenxresoivsfiexfigfevoexifeneotsrfsefovsneusiewronwivuwveeionsrroffroerfzweetthniefuoetivhinnexieinewnfoovnirhweoetntitfxooneouvrifneteeniestfntfooxveotinresusoffiiivsisffvefnefnnffwiiriiixrensifxvuiiievewinwxvexosrrnoeoitterniseeuteftnniezeneewviosefnevionsnnfosirenxeneeniverioefxoerwosvowvonseteoenxinftsensetvisnongoennfutixeorrtevnxitxnowutnswiftviinwoewtzwnoeetfniiwvioonveevwrewxsenoiiennrfeiteisfezefoivififitxeorunrttiinxsniotinotretsegeoniiieeotouroiotovwfiirxiiwieoexrxnivetfinienieotirnwfxeevftnoohstsveoiniionsosireiethrexoeuhhvofeeexeoizvtvsfvvvnsvtovevooiierhoniwoiiougexwrneowshriixinoofvnunientoiixsfiioestoiintoixioruesrwuonenineieefnnuiveoixixesetofexhoeiuenteezoeerinsiiniosusfvftvxoevewitfinfvwtnreixoftnnnososiovionfhveoxeueoonxoxiioitnfoorntnennnefffsesnnovuffrxvunreexewretuenxwonisofnfxxwvtrnerwriitvnefexfteennixvientxunfonoottoetsenwofefvitwnefiweotvsoohxwseiiftwotftinxsnniefenfixeieoveeooonoofeioenevesoifiieoirrorxoxteneionvtntiersoixftnxvsihoxuosowrevoteeniigwsinrisvostniniiureoniuxoezfexvnosniuxttwitroeeuseexosoiofvunottxfforsnotreesewoersnireoivsrusvsixnrvoferrxiuretevenevixooetheiotwiustxwneeitxoivereeeoofevhnoinetneeenxfnwfiofxniwnieoeseixotrveiexorfsxwwivxnooovfrstoiehsonfvsrioififttfeehxuoeveieogntoieerseeffieiixxxoieotreioirxfseisxxvregneossostiooxuousteetoxfwoxiofngtniivnrnentnxfsonnseuivisevsevooiieerxivovxeixoeotuonifwtisewtsooeetuxoennsewxsifxttviietxovxoxxnwsoeteiieefevtnoiteihswsihoxoiofwveooiwoosowrninfntenrnisvieiiseniwxvuxixewroeeoniufeuvnuetwosfeseeeristovssiroeftrxirwwrfwneoffeieeeoeneornseniveoineernfswfttntiinntowtnowxtttetenonoeexsneineeneivnvtxisiwefefnehonoosrunsxssvsonnxtneteeseuxeoixrnsrwfnowsfioiiissioweesfonsroinxoseriuoninfnwuwuxtoixsfnnfevrreoitfoefnnrswiixfeofswwivzrniixfoutveoesennewvenefnvfexitfosvtefsvwvnstvverifnorioehvtevooroiiexeruwfsrxewunxiwxwnithfnvtotefoieiewiwisvfwtoxoiniivsenxnssoteeenfnxrteievseevoeueonnuteesfwvrnfeiuuwoirrvnnvovoenownfotoeooeewrwueseeroosveoeefsfnnixvieivrrnnfnnfeutenewxofnensoonvofxxfeinireinverooevsoeiirrosoevuenotrvitoserstivsfvoixvvfitenieftfteinoienesuvhnxvtotwoeorffeneoinoxtiwioitoxneneeontwxvsvnetrveoesieethixfeiossohiixoonsoirxtiesrwzwnesneotritwonsuneofiiofxiiueeoiinirvfuutrhtreiieeeevfeeswrvovovuiwioeefnwffooefoeiesiiiiinneveoxxoxxonttfxfeionnesgiinnwfniiefwntswteonwiiwterioosnenrinernvfheveirfsvnerwfesnwfvseifxevnrieveesetvhsisrnxfeistewxstfooniwruxsoifnhoirinsrneersirgfneoirithvieeftuunevvroerueustnfuewethonxtivuvitvfwneisttioxioinetivstfforwfinerxioieexrixtrneneeeeieviiineisevexewrhwiittixrnwvoiesseoesweortfvfxitofuwvivninwsnweeevfronotneeozwrwrxoneereneveiiofieffvfriivvweifnuiwefoxgefrfneiiiownsnnerisoxssvreoeotfnfxxirfwreeivioswovnnxxvneeoieoostievixnseooioessvooiuruxfoueroooessioeiiffwrwnfenwhfeihitfennoiiwoigsorrrwwotftxevxwvenxfvroovotssixtwoieuotioisnonrxnsnnvesntofvioesioovretonwitvsvxthovfwevfuwofrxnfexxnitronxwnsnueooxeeoxoeetveotwiooinioxviixefiovreinioivxxsnoeihuefotsrfrtieeetesxisoeneuwennfneieisnweneonhiefniihorfswefrnoseowrveeoieftowsoffvxnxtveervewoesvessesiswiwrntnwifwuuierfoiivetxeetetretnfnnnwrofensxwnwxseseesixeifereeihonffwsowntvihntioeorvovinoieeetsisfftgoofexfnwsivxievofeisiesretvezuiwifxihevtievtonniweixniriseessoooonxvirfitxuoeoeowvoontiuowterxeruofxetisuffroitfieeefxefoovtfxwxioxniifvxounvxeioiifoengixutsstnoixeifeivifxnrvsnftsfioritefosiozowenetexsnowwieonrfvnoxfueownrstnifsievvortoofinereeonneieseiinreetesrfrxxniexvvnnsfxxtwoiefwxniowiursrrttreunsforisernsvffinvexrrftseionixiesnixfoersentiteioiiierneienfssrinirxvwtovtifurneseneonnrsonsvrwrnoievieiowwvootnnfootiouotvtnnfeeefexrnhrninsoriounneoveiteessnutnxhtsovtfusxonovnrsuxrsxviinioonvoinniuussfrtennnonvevtooffrsonxvvrtrwovetesoteonougnuefnnioosfoexrxtorfnxeewteeiiiofvotenxseeezwrwitxhhxefrtfiinofvhiioeftsittwifhxvoeoitntfswwnuoititreeoeveseeriowviifnzexeefwvefssnsxesinonixxxsieerefxenfeeuiuefifwvxoniowenetorsnoxuosoinwiieweineeifesxewieixrhfteoiiszooiexfevioefwxvxetehnuuifextvfoiitntioviorutsowenoitrxnntxwsrvnouseiwifeiteeeennneeoffeoevvtuihtiwnuifniefioorxrfnfexsevntxnnsewosetutnxseseextonvvsiuxieivnoniiihoxxtextssirwowvoxfsvsirhoitrwvxifeoenoesoixenfruivtniweoxivsnfieniorwnesfviiservoeooeeonenehsnirieixofsieeiirfnoeioxfssftfwtiousiofwooeinsfnrvfvteeseievfffvowsesveviixxiretiieoewhvrovowienenvifreowsfvouteeiohsnxnirffnfsxeoeeiestfviiosoiohntwneifhfrfeniefnieeeixioiifrsoswxesofnwsietentoioifneniseuioeswroeiowwexvtwtnstrfgoeigiiwwiierwiexneefiswsxeewiuhvsefvsveoneietsxeiirxsiieuiefeissrieuoonreewtiooiwinrfuvuvsoersssovnvxonwiifvrroeoxuseoovfietxoteenvivtosofiorxxsernsexwnfeefihnseseoifrewfofossirieeivostwiugnoeeoifresntvixooieunfwuxrnxwivntsnfsnefeeorxnusrwexiefovvweneietfxvfeneesoxxeiioeiuutxeetexiuooiifeuieswnfiensewftfotsnuenrfoerszxrufvexxnoexniownotrnoftifnvrivinnnsxiioxosorwihsfninieetrfgefntfeeswfnrxssevseveennfnifgfetefhuitsenfnxsiefsooneivseoeoohesixesnotwwwivixxintfnixonftswwrerweetoxxnixosowuronenivhrsfutenfnuweeenioehneifntseeexreifeeftetwneexixeiesfennonnneoetoionfvnrenxeutiexunvoxwvriifvsoxsuxxnfvuxoiniroinesuioirusfurvstesrioewseixneowoineeveinevivtoeinsevtiwwswioriosfviveifrxoriisvioofosnornivfvonftnixfefvfwofnofevnfevvhnsieowiseonxrrsnxrifesioixxsuveotieixenffreoivxgofofnooroiisoteuuevefvisisfonoovtsefxneezsivvfrheeiteisuieivfnixfneounvfixfnervenfntesnsteototieeoiotvnvervxerrwewowsisxisrsuieuexxoeexoistiwirvwtfefnresfiifteoefviseussivexixteoewivouefoeuxfoexeotfiiiuevvewziexneefnonifveoihworexeunietnvvxnosoeoonrieovevoinoisvwionfrnvtfifeeooeiietintsosswenoeeetnvxuxfzrufeeinwwevwoiuusuueiviswfeznrsereuowsuwsirnznsvxfoeueruioeofeeeowsvetounixsvvvewiouxueeewevennxftwvfivniwufsxuoenewifeoeeewxtfxeoswvtisveovsivurwexfxeeotfxnwxtsvvsftesroeeiowfitoinunfnvwnwnswsiefivxttrveseivoxiinuntefenuewitfftxnrwsixsoheinxeenvetoownxeefneenwsoeoxoofoweohfrtexnsnviigiienefvxnveioiitttooviiooohsiiiwtsieinowretixniieorfofoeenrufhzxisisvonsnxeexxrwnxreresensitfeiohxihwesnuouwevtntioteofexxixorviioooxxtxoiwosuinvesisnethfneniwtxfiiuxihroiwvteentuoxoeseeesfweevixivvoeivetnswxishooioinexevxrreirerfntvfioresowursznoeneoeesihsvensenonswuvsfnsionovvrwfsffneeeixnofiuxtrxvnninhnstiownnefnnheiweieioixiiseeefsvvxeoonuofrniswxzuneeffteewhwofuesrrttseeoeonnoeesxirnfefigeveefiififvnuoinssfervxrrenesewniienoexfsiiiivvnineisinuwwsinsiveeewhisuxnineuufxrorntxtnxwewneexeewioeetoosieirxoinexieiefevofnstoonfstftfiseinexsneiesinetveftefeefneoeoxsfvxuironuvtevnesfvtwvrfvnfsooeeosfeeiotteoserfvwfivseinuoietofvhnxhsifonioowoowvosiffoseooefeeotewuortioionrrrussvvosxieiteniifroenuvotuonnseertnsfoxnweffsongswoxreievtxfrnhrtsssnoievfzwnnwiixrerfixrtioesneweeioooeevvenveuooigtwroxioontriwsewuewroeniorstneftrvoeeeseiirnxuvivxnfewxnnnsfnfuneeoevveiffnswviiwwieinnteoxvierefeioxnwonnxotrxenetxertsnfonntwtfwxxessreiesxoeixihxihnsnnxieuioifvnvirnsrusnnnivennihixtiinfeiiinonvgsiseiuieoesvreffwunutionsernstrfrvweivovtzritieoserevoonowfiieieviriivviinneouxfvnuvvrzoiieovnfwizeefwxnfwoewsnoweesftefhtheioiinnreeesxosxreexeevexieefeseifoifgooeensnfiifwwvteeeoonnexwrvioxossfwhzinixsoieevnnuvertrriiwvriwnuntftvnssesuntneifeeefewseexoierwsesnixxofitrhewxiiieizeiieiiissosnnxoeoewneviffwnoeoesontvnfgifiiiiwewiieiifevrvtrzifnovfennifiiinwfsefnssonvweooiweeoufwxeifisiieewevifovtwofvseirnonovrfninennvuuiofifsusnnnoivonrwesueeoirueiofuwrvvnovtiuxtnevtnoivfwivnsistsouffiouvtvnenuowvvsthrfniiwisxriinnefuresosisenfnsoreefuinixotioienoiwntovrewfiisonenetosovrfvotwenvsefowrvounvxihwnefunienrowenueeesieoeffsntvexnsnssoeniieevennxtunovevnevexenieifiinotsifofvissufewxotreeisnivxnfsveveefnosnhwefxxwniieiuevxutneiwtowniieoeieifwevtetssenovfnvtoiriseonooxtininwffewoifehwvitnwefwieonvefetveeetftesszefxioerftusrwxeefsverooisiwswsrinnsrunrrsetsvewrevoiesgoxreioieowveovoteiriefwnesoiiuinoneooeswsosiieuwtooeisueofefeeneuxovntxrnrxwworweoesffoeneoiossroefinoreritseeeixwisfisetrnwtfvrifesieereoinwxrifsostfveerxivrosofeiftfieisonvnnvwuieeiieixxsoieentsfnootuwvronsuooenrornxenunfntetnssftieeniineuvixifeeooihfvsfeeoinwereetinsoufsenefiisfrsfeneewtxeotnntooofexhixswenfevftvonixiifufintniviievfeoowveotvtexronrtesegtwuvsneennifxineohxwrionvtionoeinewnxrviseetegsoetexnunweienevveiexnoofietoofxvoirirothrfiennorienoneffoefsfveewwsfiweoetfeorooriieviwnotfutnnrsertrviwooefeoworefeureoenvwxrnneuntvevinoeereeoenrvnheexsnttrsnniveerenvueuovosxxuooefnesfrextenieonrsxeetowehnonsiieeietrenhfxeeresveiringefttowuxifovseooewiiuostixvsewrnevvogoiufirssfwnfisonroeewsvvoonexwvfowintetvnsrietxrexrvfwnxwfnwneieennrreffenureefitoeffrotxoxoenoteeenviootffoxrevifeoeiivtrrtvwiofsovssnonuosiiirstxtewfieotovsioetntinoovnitvfsoeeswvotnisinitoeietefvtxfofixsgefevwotixvoeswfvnferevfooioffseeoiifnefvwguioevofxxuovfvsuenotviuvxseeshfoxroixifvoweoesoxesiwtefvneueoeeiievwnvoitnrvtifeeifoeninvertxteriieeoxinuouhuiesvinihisfrnfoxxfwintrevnenfeeeosonffnxxentioitrretihiewszowoffeensrooeooisrexnsxeesfxufereirrntiiunfhzrhvxszeenoeniferfssnisnonxreoifsooxeinizfsefeefeioxvnoitiiefsninfifoeoenwueoeuingeeeusvnwruooxwsfoenwitiriitivsefheifoewxetrofswnoexntvvfhsiwtsonoooniwexeenfiiuitveeexwifntnniwvrufeofoioneevgsifoowoifevihoteuuongtfiuewesonvxiweusvuoooeiineehsfxssneisnoootstshfuirtsfierveiivewfniooioeenornufewevofinonifxvfwuveuutwnwtgnoetssoitiwninnwfnseonxehrxefesoiefveswnixtexefxexxxtenieefonhrrsisitfewnfwvwreswetexsusxhswvtnotwwiwvfeoiutiinrnoxxneoiueenwsiireehtvxwsreeeefvteoeievnnxfevforofooiwefvovwofvosxrntevnoeeitieoetniiittoiheieethfffxvrfeonnsrfeossetoxnvfehvnteiiioufixhftssniohnowfnfovnhtftiitureieonfeiesnwvnotuehutefsenntvwvuoffoeeewuitnorienrereeeefsvsextsonifgxszefiiertefhnroteiisxtoweifeexeoerevesriuxexosowiefffenoiienenoosieeotugunevuenfffsiivftnennsiivxnrxwfsoiestoeuvoieonnxivoeeneeivrveoefxtnoefxtsnrxsnhoiennoveitnoefxffieievieuseeorenhixoievinenertetfrnifrserosueeenwtwhiunhowtfinenssisnwrtefrnnxgxnetieiovwosoiiiirinevwovffwnrniiifivwtvtnesievnortennnffnvwsosorxentiofteehirirsotreoosevoxsvtewinovnenoinnvxwfxfxnoeeiinvefvnoxnznxfonniwoeeuetnerernfootrfeooiievireoseixotriehefonfvrhootioforvfweetfexfrninftntorotfeitixfeeneheiwinnrinretoetiofwinevxehrrxoswvtewroniiuxienevoifunouxefonfotsfioiteuietesfeinfvrsiivetrnxevoveirtfoevunseuufirvsnurteuoweuigreetovtvieonnenifsiooonnefntnnoovssnveennssvvfuntiiefixiixnveiseiseewinnowffneiwvviesittontesevxvtnvoieoentienenserwnniefxitnwevneiwonxeieeroeftoeiovtteriniennsiesnfrnnnxniofnheeeevnsnonnfwxetvnntnehiestfrioiwxnuwexseinfvoeftnvhiersexfisneieziexnexufwxtehenwieiuenowneinfirsxuovoieifrusieswieefofiwfoousiuevtsivvieeseoxtvtstuorfrfexeneneeieooneivieeewefntiviuhtvfeftooxewuwintfxeorosiiwonrefsxnonoiwenrstrnernfenienowteverfseeofwiwrteetweofoxseervwteethsivvnoviweowoieerhionvfoosoeowfiwhrsufooirweeewniuunrwsenrxoeoxfeoevnitiztreufxtuoettvoiefioeheineoeetitnnefntxwvixfiiiunexvniewxoniviftfifxivtenhvsftufninnosuoeeoeoionvennneinerieresostostwoovzwohoftreioeoixoxeininessneeetnntetieoieueiwrruieooowfsixeienefexehfuxxnhisosoeevevioinfoexniooefeinivfnviioneinofoeinsffifvesoooeonovtrterhewiisfvnoteutesetuooueiiufhnoitvotisovsieieovtoiwsieueieeosefouitevoertnotfoxonoetrnxoivhixisweoteonreiooffhivfesfwshueriwonowenseveoxftsivefihoeoofnoewtiorofuveofrnsinewvwtesvnrtsitiuouoeexweoenveiwothoowoeowexiioovvenierfxineiwxwxerenoetenieenenninsfineetnfnnsffvetsiitoffsssneseeeevftxoiiorwforznfestunurinvofevoeefenertovefiiofftreiooevxisuseosroeexsefisrsovftihfnsxttuforenoueosnonterounonfssntouieenesurewfieiovtsnoxteweenienuirfvitnonenwoeortnwiseutxestwiwuseetuefeuetwoevorinefnixsiseenstttovewireeooererotfiveoieinfnvvnevwsnsioxtvsnsterxereftnteeoeesfrxwneerfwtenrxifroeenexfonnsxovouiuroefvtofnneioeeessetntewvtxeifhvonewvnrinheneeeoifxwiffheszsnxonwifsfnfeoxxfeoiiefsfoxsxneeuieteveeeseieswoefzeeeofxownfeneeerxnufxextxwwierfiiifwineterwffifriurvoeofvwtrnronfrsrfieotfsseovsusfioexnsrenfnfsiiiwoeeiefifoxnenixnniefiesuxuvifeuwxuosfieosxfhnwfnfvvfexeinnntixwfohsoeenrheueieeeveotnvzoiwuoroxnoefsfovesiifewxxnsztevienvorovfseineofoofsvfooeriniooivessrxwfonwnveeuvsssiewxorsioveintnetetoiifsteeienooonisvnfrnttwieheinfifssorxnovoetonrroeswiutiosiuerwteitfweeroovfserneenofiionfiioteoievzeviieffoesowiwnoxoetssotteeeuvfneixnuzvetntivfrgeuerfxnxnifeftrntirvenefvsuivivnwiwfrvnoixxtrveefisizorrioeeitohesvuefnsotvtfrooowxfvonrovetosxiroeevoifoxfseevnfnoienetoenrsiineoessireoeroiifousfxerftswiievuiwrneisfinwonigfofwoxoiexionieroooetoiveefrwtovsfisexeonrnneiofuvewnusounnoffofvrieizoosnteswnfnofesifteuivnueisivrfxoofrutnitxwwnftxiuwxsouwfooxowiefruosooxiixvtrvotegntiosrveffhroieitxnetnfsiuifesfionevfsfoirefiviffittrwwevturooixfvinevhrtswneetritvteosttesineueoovoiexotufivutuoooofiuvwhfsviuteehoffofewoviwefooeivexuofvhiieienwfuwsehsriuntienrweoivoxvwouevsoifeeoixsnioeoenunofiexrixuexteereoovvurvvoreorftfneoftisesefowswrtfoorrxhifuivoveetfirseixfvituriwvwrreiioifevtixeionwffeeouisotfvfniwnfowrifftvneitooeevsvwwsoifueioxosutronenesnssiritoifffexfrnitetvrxveeufvtserzviseoneroossxrnuitteonnouinxrtiseettefrxvfxfinfoiieeivwrweenwerswxioefeetioivfwewtswvewvinfteeueofioohueseoootoorhufxownexirnoiiifisffiteofhxsreffeotiftiwieoxxevihusffsosrniviuwuxoexerosoievisiioeoetowtxostfrsfeefussoffwithihxtwrfifioououwensrisewesofroefuseresooxsooxvxtsixtosxgxeofieuoovfiwieoxuoenissieoouuifhuvuvwierrrsfosioieiseoioivioeefefonsfvxiifvweoorotuevofvotroresewffuieunseftvoexereofetneuifsxoviettxoxesxrvriesvvvfnwroioifvrhreffxueunentvueeeoivfoweeeeoosufrefrxextifexxfhsutefifwsievihirvsioiiiotffersetieweeioreiirfviefiriseeifvwottfvsweuneffhvfoewtioteoiooerxswioesivfetxeixvsoetexwxsuoorenrvoiortrefifixsfvoervvtrevnonsoovntoiievfrxsoivesvivisrewshuoetennsxexeoiorvgwoouuefvifstfriirveseriooeevvioxrzvtttieifhrohvtirrsiwvrfrosfwxxxfwsextesiriveiseiirsunwoinefwiwsexirusoowwufoesruxiesuvtssvwoufeneifenfwegoiovtvtooixifreeoonshnxwrhorotofewrnfwvenoxwweheshehetxvvneoittisvsewvsiwnwwuofovvwexiofonnfetrivwrftsowrhotroiuerxeiizsoeswxofehuviotenevthoessuofntoterneiowrtooreeivwezooivtvfuwifinisfttrvxvexunerewioretfrtissoevienuievofssueowniewwvovrfeeoxetvissxouxunwueivhewoorrtixseinofiexneentieeooeifetiiexreftfifeieoooeonfoetiihreninfifhtfesfoosisoirtruwfneesuwixxerxiriofiizgxiteixwrofneunvfvffxtrsreexfxirnhrwhsofnwveiiffrxfferifwiwnnxnsutvxffuevoeeerivtfthiiouieweiheeiioneusfenittvofxezrnehxotenehoewwiifiitenwisenvifxveeinitervifrseooiiveesutifrvewxntvneiifnfeoiootesnwutexihefgwniteohhoorfefixsefoexoioewvnveisviihsweofstrsioennfiwisiffixoeeuoisnfoeenusorfofenxowrrwiniifvuefortnrenfwwereetfrfterueeoetxnesieiwioxefteventrorrvieuovoxtffiretioxursnzovovoxtoefenevrrusesehtifnntvovsftuoviuoihvniiivxtoooneoeuufeixfeefxosowfnuetsinitfvsoonxsfxnxetheiuvifeoxosvniiesvifexsxvotouienvhneseofeoitovnuvfsisforwuifteserifrtxohnnoourhffexfoeotvtfsohofooeoxwrwstteinxursftsioesinnrsfrnitfiwieiosefsiooorxnevioieiisoeeuoeoinfuvtfefxwonttnvixorxtoveifenwsnnooovsiefwfieoeeeeneweexohiuefsvtxenrereestiofsofsofnettorzroxsiffewofseoeoxoiitostonvfvsxtverisovtvewwrsetehetwfeiuffniirirteeifrxerrvsgnteosettieiuoeveuwosvftsnwririueeoeeznnoovinwitetnvtvfuwsifieveionfoixrnhefrfefvevotohveievntxxeeuohfsvstterefuefxtoeoruoxxeeioosoevfifnfinosvivoteriivfosuehxtrnoteeiifosovfoentnnstrtsiievoiixooiinfosuvsfoonvxtvuoozouefeieetxhrnxixoxiereoenitefiehetenowviooihfxeeewivioofinftxtowoorneffeeonofoxeeihvniewxuiivrsinvrihftiiiihvotnwfeoonfweeinoriotofiwuxsuiinsieewhwnefeehwisrieenvieeriteiiiroesfeferofvwovfixowfwefevovrfvxeeeootnfrioreititrfvohoitoreiovotvfnnvnseusfxeoeinrotueooeuvxfoeofosxstetxsftonrvtesftfsovexotxronvieifeeueewiervuoeonuesxefienowoonfvntoufvewvietiiioorsnrhnfevefoowoixeefesexsttenwieuttnxoouootfiweofeoooxneutfiveonshxovwioetoisnxftohrusoeouhtfnevhxsfifuesfnihoofwexsovnerweoiezwxeueixiwvfwoeorffeefxrvexenrirviuueiruxovoeneioxuuiiuotttfvtxvsnevsisxftwestffnnsxonofnoifitoeiwintieisevsesgieorxonooxvhofusfuoteofonhvevovsenienoeerfoisffiiuinoeehnenoxtwnxwevwtufteusftvnsntxooesiweostvoerxitoxsnesefunioivnsesvzfofrgsirerefowfnsvvsferiveiofrofwssvneowoehoofiriouefovesvfeuonrwnineseuhfirvtetnivnefxeevwiofrhtenzeivoneinntwxevituostfeiowsweniivitnntooenerssoeriuoeitftfwevxruusuvowurexosvutowrffxoeneswoeifeoiioevehotuwuewnnwwintiuntfontovifffwfofivvenevhrrenfixeieweusevrfzohuovrtisooeexioonorioorvtfnnfteseirtuefestsweouxtxvvnrefwoitiefooveihsnweswnxniewffeexnrnvhsxeenhtizeiitzvivifeefoxwosifwfxeiixwosunttesvvrxrwesxioeeeexferohetoixtvtosereitfnerrwshuonhwoieeiofeeiioieefrfeixhexevnfosestfnnxvnsresowvwnunennietiiwototeunrissouoveitotnewroofeotfoonewfewxifvuefnrnnvseosffexfisetttuvrweovuzittiivtowvoiiofvoeevefxoisnwxneoooiiweeetwfvituofxvttfteweeifnreiisooreitotniwenonetffenvhzteviioinnoioixewnieefuwtfvnireefrfxennooesvuuwnesisvxfxfeoneonfoewoosneoooiiefuxnezxfvvffsteierovoneiunewrfeeiouuwtwooifiernetsooefxifoxeinzrieuieeunrienvnnroeioxvxweonxsennsxeuhzerwseewnoefsinnuxvovswevieuffsexieeewoifoennssioooufniixesensxnftegetnuiieeivfteoervxiinxeinfetsnnetixnewifnvieinnotroerwfessuooiewfrtooxofetivrnsohosoeseweseffnrxsneeintrfneoieioeixwneervvxxitewufiieeniieftsffisefooitxeteeenurvieefhieorneivvheunewevfxuoonfseffofrfnnfxwxsueffnirsiftirnfiwonoonoieonzeivheivfsxuoeerrtoiooeeszvweitnevstrxfeurtsrooevfiseonhnetnnxoinfeeixtvtrfrziieeenineevenftwirnixwuenwenteiiieufoffounfesfehuxiveinoifiofwfeiiexnfixivnetoixrieiueeeofoowteenrtoxunoenffisnefivvnosfvwewwexvoveovitrvnxoofnireovvfeeihierexntihinresexwnontteexrveeefeoneissswwfnsooisxevwfiivosonuusuowenusoennowiersorirrefufixueewofoeerioevnoinvietfnifxvsssnntoxeeeteniiiiehoefixnereiioefeoufifieesioseveviinwriiosoiuivesrnrwwsxoeiiiotnxnevsxrusoeeefiorihsoewxoifeuietexsweixfifowsefeifofowtfnevnfhvfotwsnevwifon"};
    for (String str : s) {
      System.out.println(q.originalDigits(str));
    }
  }
}
