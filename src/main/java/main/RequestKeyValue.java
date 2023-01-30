package main;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode		//필수 url과 method가 같으면 같은 value인걸로 할꺼기때문
public class RequestKeyValue {
	private String url;		//servelt path
	private String method;	//GET,POST
}
