/**
 * The MIT License
 *
 * Copyright (C) 2024 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapisixtynine.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.github.astrapi69.collection.list.ListFactory;
import io.github.astrapi69.file.create.FileFactory;
import io.github.astrapi69.file.search.PathFinder;

/**
 * The unit test class for the class {@link CsvExtensions}
 */
class CsvExtensionsTest
{
	File validCsvFile;

	/**
	 * Sets up method will be invoked before every unit test method in this class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@BeforeEach
	protected void setUp() throws Exception
	{
		validCsvFile = FileFactory.newFile(PathFinder.getSrcTestResourcesDir(),
			"invalid_key_pair_algorithms.csv");
		List<String> lines = ListFactory.newSortedList();
		lines.add("algorithm,keysize");
		lines.add("ELGAMAL,6080");
		lines.add("ELGAMAL,5440");
		lines.add("ELGAMAL,7040");
		lines.add("ELGAMAL,6400");
		CsvFileExtensions.writeLinesToFile(lines, validCsvFile, "UTF-8");
	}

	/**
	 * Reads key-pair entries from a CSV file and returns a list of {@link String}
	 *
	 * @param csvFile
	 *            the CSV file to read from
	 * @return a list of {@link String}
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static List<String> readKeyPairEntriesFromCsv(File csvFile) throws IOException
	{
		return CsvExtensions.readEntriesFromCsv(csvFile, csvRecord -> {
			String algorithm = csvRecord.get("algorithm");
			String keySizeString = csvRecord.get("keysize");
			Integer keySize = keySizeString.isEmpty() ? null : Integer.valueOf(keySizeString);

			return algorithm + "," + keySize;
		});
	}

	/**
	 * Tear down method will be invoked after every unit test method in this class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@AfterEach
	protected void tearDown() throws Exception
	{
		validCsvFile.deleteOnExit();
	}

	/**
	 * Test method for {@link CsvExtensions#sortCsv(Path, Supplier)}
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	void sortCsvFileWithSupplier() throws IOException
	{
		// Example usage with a CSV file path
		Path csvFilePath = validCsvFile.toPath();

		// Example usage with algorithm and keysize as sorting criteria
		Supplier<Comparator<String[]>> comparatorSupplier = () -> Comparator
			.comparing((String[] columns) -> columns[0]) // Sort by 'algorithm'
			.thenComparingInt(columns -> Integer.parseInt(columns[1])); // Then by 'keysize'

		CsvExtensions.sortCsv(csvFilePath, comparatorSupplier);

		List<String> entriesFromCsv = readKeyPairEntriesFromCsv(validCsvFile);
		assertEquals(4, entriesFromCsv.size());
		assertEquals("ELGAMAL,5440", entriesFromCsv.get(0));
		assertEquals("ELGAMAL,6080", entriesFromCsv.get(1));
		assertEquals("ELGAMAL,6400", entriesFromCsv.get(2));
		assertEquals("ELGAMAL,7040", entriesFromCsv.get(3));

	}

	/**
	 * Test method for {@link CsvExtensions#sortCsvByAlgorithmAndKeysize(Path)}
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	@Disabled
	void sortCsvByAlgorithmAndKeysize() throws IOException
	{

		File validCsvFile = FileFactory.newFile(PathFinder.getSrcTestResourcesDir(),
			"new_valid_key_pair_algorithms.csv");
		// Example usage with a CSV file path
		Path csvFilePath = validCsvFile.toPath();
		CsvExtensions.sortCsvByAlgorithmAndKeysize(csvFilePath);
	}

	/**
	 * Test method for {@link CsvExtensions#sortCsvByKeypairAndSignatureAlgorithm(Path)}
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	@Disabled
	void sortCsvByKeypairAndSignatureAlgorithm() throws IOException
	{
		File invalidCsvFile = FileFactory.newFile(PathFinder.getSrcTestResourcesDir(),
			"invalid_certificate_signature_algorithms.csv");
		File validCsvFile = FileFactory.newFile(PathFinder.getSrcTestResourcesDir(),
			"valid_jdk_17_provider_bc_certificate_signature_algorithms.csv");
		// Example usage with a CSV file path
		Path csvFilePath = validCsvFile.toPath();
		CsvExtensions.sortCsvByKeypairAndSignatureAlgorithm(csvFilePath);
		csvFilePath = invalidCsvFile.toPath();
		CsvExtensions.sortCsvByKeypairAndSignatureAlgorithm(csvFilePath);
		System.out.println("CSV file sorted successfully.");
	}
}