/* 
 * This is how the two array dictionary works:
 *
 * The idea is that both `words` and `definitions` are initialized as arrays of size `MAX_CAPACITY` with each slot storing null.
 * Entries (words and definitions) are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * words:       {w1, w2, w3, w4, null, null, ...}
 * definitions: {d1, d2, d3, d4, null, null, ...}
 * Removing the entry for word `w2` has the resulting dictionary:
 * words:       {w1, w3, w4, null, null, null, ...}
 * definitions: {d1, d3, d4, null, null, null, ...}
 * 
 */

public class TwoArrayDictionary implements Dictionary {

	/*
	 * Using these attributes to implement the methods.
	 */
	int MAX_CAPACITY = 100;
	int count = 0; // number of entries in dictionary

	public String[] words = new String[MAX_CAPACITY];
	public String[] definitions = new String[MAX_CAPACITY];

	
	public int size() {
		return count;
	}

	/**
	 * Is the dictionary empty?
	 * 
	 * @return true if this dictionary stores no word-definition pairs
	 */
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param word an input word
	 * @return the associated definition of the input word if it exists in this
	 *         dictionary
	 * @throws WordNotInDictionaryException if the input word does not exist
	 */
	public String getDefinition(String word) throws WordNotInDictionaryException {
		for (int i = 0; i < count; i++) {
			if (words[i].equals(word)) {
				return definitions[i];
			}
		}
		throw new WordNotInDictionaryException("Word not in dict");
	}

	/**
	 * Given inputs `word` and its associated `definition`, add them to the
	 * dictionary.
	 * 
	 * @param word       an input word
	 * @param definition associated definition of the input word
	 * @throws WordAlreadyExistsInDictionaryException if the new word already exists
	 *                                                in the dictionary
	 * @throws DictionaryFullException                if the dictionary already
	 *                                                stores the maximum number of
	 *                                                entries
	 */
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		if (count == MAX_CAPACITY) {
			throw new DictionaryFullException("full");
		}
		for (int i = 0; i < words.length; i++) {
			if (words[i] != null && definitions[i] != null) {
				if (words[i].equals(word) || definitions[i].equals(definition)) {
					throw new WordAlreadyExistsInDictionaryException("Word present already");
				}
			} else if (words[i] == null && definitions[i] == null) {
				words[i] = word;
				definitions[i] = definition;
				count++;
				break;
			}
		}
	}

	/**
	 * Given an input `word`, remove it and its association, and return the removed
	 * definition.
	 * 
	 * @param word an input word
	 * @return the removed definition
	 * @throws WordNotInDictionaryException if the input `word` exists in the
	 *                                      dictionary
	 */
	public String removeWord(String word) throws WordNotInDictionaryException {
		String s = this.getDefinition(word);
		boolean t = true;
		for (int i = 0; i < count; i++) {
			if (words[i].equals(word)) {
				t = false;
				// shift elem
				for (int j = i; j < count; j++) {
					words[j] = words[j + 1];
					definitions[j] = definitions[j + 1];
					if (j == count && count != MAX_CAPACITY) {
						words[j + 1] = null;
						definitions[j + 1] = null;
					}
				}
				count--;
				break;
			}
		}
		if (t) {
			throw new WordNotInDictionaryException("Word not in dict");
		}
		return s;
	}

	/**
	 * All words stored in the dictionary
	 * 
	 * @return the collection of words stored in this dictionary
	 */
	public String[] getWords() {
		String[] nWord = new String[count];
		for (int i = 0; i < count; i++) {
			nWord[i] = words[i];
		}
		return nWord;
	}

	/**
	 * All definitions stored in the dictionary
	 * 
	 * @return the collection of definitions stored in this dictionary
	 */
	public String[] getDefinitions() {
		String[] nDef = new String[count];
		for (int i = 0; i < count; i++) {
			nDef[i] = definitions[i];
		}
		return nDef;
	}

	/**
	 * All word-definition entries stored in the dictionary
	 * 
	 * @return the collection of word-definition entries stored in this dictionary
	 */
	public WordDefinitionPair[] getEntries() {
		WordDefinitionPair[] newWD = new WordDefinitionPair[count];
		for (int i = 0; i < count; i++) {
			newWD[i] = new WordDefinitionPair(words[i], definitions[i]);
		}
		return newWD;
	}
}
