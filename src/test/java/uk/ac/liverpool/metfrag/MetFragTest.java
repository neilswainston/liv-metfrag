/**
 * 
 */
package uk.ac.liverpool.metfrag;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author neilswainston
 */
public class MetFragTest {

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMatch() throws Exception {
		final List<Map<String, Object>> results = (List<Map<String, Object>>)MetFrag.match(MetFragTestData.SMILES, MetFragTestData.MZ, MetFragTestData.INTEN);
		Assert.assertEquals(5, results.size());
		Assert.assertEquals("C(C(=O)O)OC1=NC(=C(C(=C1Cl)N)Cl)F", results.get(0).get("SMILES")); //$NON-NLS-1$ //$NON-NLS-2$
		Assert.assertEquals(1188.6403357016206, ((Double)results.get(0).get("FragmenterScore")).doubleValue(), 1e-6); //$NON-NLS-1$
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetFragments() throws Exception {
		final double[] expected = {13.007825032, 14.015650063999999,
				15.010899032, 15.99491462, 16.018724064, 17.002739652,
				18.99840322, 29.002739652, 29.026549096, 30.010564684,
				31.018389715999998, 31.018389716, 33.014053284, 34.96885268,
				42.034374127999996, 43.018389716, 44.026214748, 45.03403978,
				46.005479304, 46.021878316, 46.029288748, 47.976677712,
				48.024952316, 60.021129368, 60.044938812, 60.984502744,
				61.028954399999996, 61.032777347999996, 61.992327775999996,
				62.040602379999996, 74.036779432, 75.044604464, 75.048427412,
				77.003226808, 77.02386901999999, 78.995067428, 79.043342032,
				80.990730996, 89.047678464, 90.01105184, 90.055503496,
				90.05932644399999, 91.01887687199999, 91.03951908399999,
				93.010717492, 93.058992096, 93.998556028, 94.00596646,
				96.001630028, 104.04734411599999, 106.02977590399999,
				106.05041811599999, 106.050418116, 108.021616524,
				108.961180456, 109.00945506, 110.017280092, 119.05824314799999,
				120.06606817999999, 122.013457144, 122.037266588, 122.061731748,
				123.021282176, 123.02510512399999, 123.03251555599999,
				123.06955678, 124.97990451999999, 125.02817912399999,
				127.020019744, 133.073893212, 137.024356176, 137.04816562,
				138.032181208, 138.036004156, 138.995554584, 139.01619679599997,
				139.043829188, 139.0644714, 141.035669808, 141.97523374,
				148.08479224399997, 151.04000624, 152.024021828,
				152.047831272, 152.05165422, 152.072296432,
				154.006453616, 154.02709582799997, 154.027095828,
				155.998294236, 156.04656884, 156.986132772, 157.993957804,
				166.050905272, 167.03492086, 167.058730304, 168.02210368,
				168.042745892, 169.054393872, 170.0139443, 170.03840946,
				170.062218904, 171.001782836, 171.009193268, 171.046234492,
				172.009607868, 173.004856836, 174.996697456, 181.050570924,
				181.098845528, 183.05364492399997, 183.070043936, 185.024843332,
				187.0205069, 187.04114911199997, 188.004522488, 189.01234752,
				194.10667056, 196.061469956, 197.06929498799997, 197.069294988,
				199.016683952, 199.040493396, 199.064958556, 200.00069953999997,
				200.024508984, 200.048974144, 200.072783588, 202.020172552,
				203.027997584, 204.023246552, 210.07712001999997, 210.07712002,
				212.072783588, 213.05679917599997, 213.056799176, 213.08060862,
				214.027582984, 214.064624208, 215.01159857199997, 215.035408016,
				216.019423604, 216.06769820799997, 218.015087172, 218.038896616,
				219.022912204, 228.043233048, 229.02724863599997, 229.027248636,
				229.05105808, 229.07552323999997, 229.07552324, 230.035073668,
				231.022912204, 231.03032263599997, 231.030322636, 231.046721648,
				232.030737236, 233.01475282399997, 233.038562268, 235.017826824,
				245.0459727, 247.041636268, 248.02565185599997, 248.025651856,
				248.0494613, 249.033476888, 264.04437592};
		
		final double[] fragments = MetFrag.getFragments("C(C(=O)O)OC1=NC(=C(C(=C1Cl)N)Cl)F", 2); //$NON-NLS-1$
		Assert.assertArrayEquals(expected, fragments, 1e-12);
	}
}