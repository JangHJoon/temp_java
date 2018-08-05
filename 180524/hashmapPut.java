	public V put(K key, V value) { 
		if (table == EMPTY_TABLE) {
			// table �迭 ����
			inflateTable(threshold);
		}
		
		
		// HashMap������ null�� Ű�� ����� �� �ִ�. 
		if (key == null) 
			return putForNullKey(value); 
		
		// value.hashCode() �޼��带 ����ϴ� ���� �ƴ϶�, 
		// ���� �ؽ� �Լ��� �̿��Ͽ� 
		// ������ �ؽ� �Լ��� ����Ѵ�. "���� �ؽ� �Լ�" �ܶ����� �����Ѵ�.  
        int hash = hash(key);


        // i ���� �ؽ� ��Ŷ�� �ε����̴�.
        // indexFor() �޼���� hash % table.length�� ���� �ǵ��� �޼����.
        int i = indexFor(hash, table.length);


        // �ؽ� ��Ŷ�� �ִ� ��ũ�� ����Ʈ�� ��ȸ�Ѵ�.
        // ���� ���� Ű�� �̹� ����Ǿ� �ִٸ� ��ü�Ѵ�.
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }

        // ����, ���� ������ �� HashMap ��ü�� �� ���̳� ����(modification)�Ǿ�����
        // �����ϱ� ���� �ڵ��.
        // ConcurrentModificationException�� �߻����Ѿ� �ϴ��� �Ǵ��� �� ����Ѵ�.
        modCount++;


        // ���� �ش� Ű-�� �� �����Ͱ� ���Ե� ���� ���ٸ� ���� Entry�� �����Ѵ�. 
        addEntry(hash, key, value, i);
        return null;
    }
	