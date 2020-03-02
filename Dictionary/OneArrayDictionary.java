/*
 * 
 * 
 * The idea is that `dict` is initialized as an array of size `MAX_CAPACITY` with each slot storing null.
 * Entries are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * {(w1, d1), (w2, d2), (w3, d3), (w4, d4), null, null, ...} 
 * Removing the entry for word `w2` has the resulting dictionary:
 * {(w1, d1), (w3, d3), (w4, d4), null, null, null, ...}
 * 
 * 
 */

public class OneArrayDictionary implements Dictionary {

	int MAX_CAPACITY = 100;
	int count = 0;
	WordDefinitionPair[] dict = new WordDefinitionPair[MAX_CAPACITY];

	/*
	 * declare and implement methods from the Dictionary interface.
	 */
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
			if (dict[i].getWord().equals(word)) {
				return dict[i].getDefinition();
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
		if (count == dict.length) {
			throw new DictionaryFullException("");
		}
		for (int i = 0; i < MAX_CAPACITY; i++) {
			if (dict[i] != null) {
				if (dict[i].getWord().equals(word)) {
					throw new WordAlreadyExistsInDictionaryException("Word present already");
				}
			} else if (dict[i] == null) {
				dict[i] = new WordDefinitionPair(word, definition);
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
			if (dict[i].getWord().equals(word)) {
				t = false;
				// shift elem
				for (int j = i; j < count; j++) {
					dict[j] = dict[j + 1];
					if (j == count && count != dict.length) {
						dict[j + 1] = null;
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
			nWord[i] = dict[i].getWord();
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
			nDef[i] = dict[i].getDefinition();
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
			newWD[i] = dict[i];
		}
		return newWD;
	}
}
