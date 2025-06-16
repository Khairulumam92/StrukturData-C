#### Nama : Moh. Khairul Umam
#### NIM : 202310370311448
#### Kelas : Struktur Data 4C

```text
ALGORITHM MergeSort(arr, left, right)
BEGIN
    IF left < right THEN
        mid = (left + right) / 2
        
        // Divide: bagi array menjadi dua bagian
        MergeSort(arr, left, mid)
        MergeSort(arr, mid + 1, right)
        
        // Conquer: gabungkan sub-array yang sudah terurut
        Merge(arr, left, mid, right)
    END IF
END

ALGORITHM Merge(arr, left, mid, right)
BEGIN
    // Hitung ukuran sub-array kiri dan kanan
    n1 = mid - left + 1
    n2 = right - mid
    
    // Buat array sementara
    CREATE leftArray[n1]
    CREATE rightArray[n2]
    
    // Salin data ke array sementara
    FOR i = 0 TO n1 - 1 DO
        leftArray[i] = arr[left + i]
    END FOR
    
    FOR j = 0 TO n2 - 1 DO
        rightArray[j] = arr[mid + 1 + j]
    END FOR
    
    // Gabungkan array sementara kembali ke arr
    i = 0, j = 0, k = left
    
    WHILE i < n1 AND j < n2 DO
        IF leftArray[i] <= rightArray[j] THEN
            arr[k] = leftArray[i]
            i = i + 1
        ELSE
            arr[k] = rightArray[j]
            j = j + 1
        END IF
        k = k + 1
    END WHILE
    
    // Salin elemen yang tersisa dari leftArray
    WHILE i < n1 DO
        arr[k] = leftArray[i]
        i = i + 1
        k = k + 1
    END WHILE
    
    // Salin elemen yang tersisa dari rightArray
    WHILE j < n2 DO
        arr[k] = rightArray[j]
        j = j + 1
        k = k + 1
    END WHILE
END

```