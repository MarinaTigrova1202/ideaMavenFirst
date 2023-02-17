package week8;

import lombok.*;

@Getter
@Setter
@ToString(of = {""})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation<T extends Agreement> {
}
